package core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.ColumnInfo;
import bean.TableInfo;
import utils.JavaFileUtils;
import utils.StringUtils;

/**
 * 负责管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 * 
 * @author 非洲
 * 
 */
public class TableContext { // 其实这个基本用不着

	/**
	 * 表名为key,表信息对象为value
	 */
	public static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();

	/**
	 * 将po的class对象和表信息关联起来，便于重用
	 */
	public static Map<Class, TableInfo> poClassTabelMap = new HashMap<Class, TableInfo>();

	private TableContext() {
		// TODO Auto-generated constructor stub
	}

	static {
		try {
			Connection conn = DBManager.getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet tableresult = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });

			while (tableresult.next()) {
				String tablename = (String) tableresult.getObject("TABLE_NAME");
				TableInfo ti = new TableInfo(tablename, new ArrayList<ColumnInfo>(), new HashMap<String, ColumnInfo>());
				tables.put(tablename, ti);
				ResultSet set = dbmd.getColumns(null, "%", tablename, "%"); // 查询表中所有字段
				while (set.next()) {
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"), set.getString("TYPE_NAME"), 0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}

				ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tablename); // 查询t_user中的主键
				while (set2.next()) {
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPriKeys().add(ci2);
				}
				if (ti.getPriKeys().size() > 0) { // 取唯一主键，，方便使用，如果是联合主键，则为空
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 更新类结构
		updateJavaPOFile();

		//加载po包下所有的类，便于提高效率
		loadPOTable();
	}

	/**
	 * 根据表结构，更新配置的po包下的java类 实现了从表结构转化到类结构
	 */
	public static void updateJavaPOFile() {
		Map<String, TableInfo> map = TableContext.tables;
		for (TableInfo ti : map.values()) {
			JavaFileUtils.createJavaPOFile(ti, new MysqlTypeConvertor());
		}
	}

	/**
	 * 加载po包下的类
	 */
	public static void loadPOTable() {

		for (TableInfo ti : tables.values()) {
			try {
				Class c = Class.forName(
						DBManager.getConf().getPoPackage() + "." + StringUtils.firstChar2UpperCase(ti.getTname()));
				poClassTabelMap.put(c, ti);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Map<String, TableInfo> tables = TableContext.tables;
		System.out.println(tables);
	}
}
