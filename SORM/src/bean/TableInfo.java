package bean;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 存储表结构的信息
 * 
 * @author 非洲
 *
 */
public class TableInfo {
	/**
	 * 表名
	 */
	private String tname;

	/**
	 * 所有字段信息
	 */
	private Map<String, ColumnInfo> columns;

	/**
	 * 唯一主键(目前我们只能处理一个主键的情况)
	 */
	private ColumnInfo onlyPriKey;

	private ArrayList<ColumnInfo> priKeys; // 如果用到联合主键，在这存储

	public TableInfo(String tname, ArrayList<ColumnInfo> priKeys, Map<String, ColumnInfo> columns,
			ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
		this.priKeys = priKeys;
	}

	public ArrayList<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(ArrayList<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo() {
		super();
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo(String tablename, ArrayList<ColumnInfo> arrayList, HashMap<String, ColumnInfo> hashMap) {
		// TODO Auto-generated constructor stub
		super();
		this.tname=tablename;
		this.priKeys=arrayList;
		this.columns=hashMap;
	}
}
