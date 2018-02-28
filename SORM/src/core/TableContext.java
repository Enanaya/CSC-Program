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
 * ����������ݿ����б�ṹ����ṹ�Ĺ�ϵ�������Ը��ݱ�ṹ������ṹ
 * 
 * @author ����
 * 
 */
public class TableContext { // ��ʵ��������ò���

	/**
	 * ����Ϊkey,����Ϣ����Ϊvalue
	 */
	public static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();

	/**
	 * ��po��class����ͱ���Ϣ������������������
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
				ResultSet set = dbmd.getColumns(null, "%", tablename, "%"); // ��ѯ���������ֶ�
				while (set.next()) {
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"), set.getString("TYPE_NAME"), 0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}

				ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tablename); // ��ѯt_user�е�����
				while (set2.next()) {
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPriKeys().add(ci2);
				}
				if (ti.getPriKeys().size() > 0) { // ȡΨһ������������ʹ�ã������������������Ϊ��
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ������ṹ
		updateJavaPOFile();

		//����po�������е��࣬�������Ч��
		loadPOTable();
	}

	/**
	 * ���ݱ�ṹ���������õ�po���µ�java�� ʵ���˴ӱ�ṹת������ṹ
	 */
	public static void updateJavaPOFile() {
		Map<String, TableInfo> map = TableContext.tables;
		for (TableInfo ti : map.values()) {
			JavaFileUtils.createJavaPOFile(ti, new MysqlTypeConvertor());
		}
	}

	/**
	 * ����po���µ���
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
