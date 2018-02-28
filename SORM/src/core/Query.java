package core;

import java.awt.List;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ColumnInfo;
import bean.TableInfo;
import utils.JDBCUtils;
import utils.ReflectUtils;

/**
 * �����ѯ(�����ṩ��ѯ�ĺ�����)
 * 
 * @author ����
 * 
 */
@SuppressWarnings("all")
public abstract class Query  implements Cloneable{

	/**����ģ�巽ʽ��JDBC������װ��ģ�壬�Ա�����
	 * @param back CallBack��ʵ���࣬ʵ�ֻص�
	 * @param sql sql���
	 * @param params sql����
	 * @param clazz ��¼Ҫ��װ����java��
	 * @return
	 */
	public Object executeQueryTempalte(CallBack back, String sql, Object[] params, Class clazz) {
		// TODO Auto-generated method stub
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// ��sql���ò���
			JDBCUtils.handleParams(ps, params);
			rs = ps.executeQuery();

			return back.doExecute(conn, ps, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * ��ѯִ��һ��DML���
	 * 
	 * @param sql
	 *            sql���
	 * @param params
	 *            ����
	 * @return ִ��sql���Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params) {
		// TODO Auto-generated method stub
		Connection conn = DBManager.getConnection();
		int count = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			// ��sql���ò���
			JDBCUtils.handleParams(ps, params);
			count = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return count;
	}

	/**
	 * ��һ������洢�����ݿ⵱��,�Ѷ����в�Ϊ�յ����������ݿ��д洢 �������Ϊnull��Ϊ0.
	 * 
	 * @param obj
	 *            Ҫ�洢�Ķ���
	 */
	public void insert(Object obj) {
		// TODO Auto-generated method stub
		// obj-->���� insert into ���� (id,uname,pwd) values(?,?,?)
		Class c = obj.getClass();
		ArrayList<Object> params = new ArrayList<Object>(); // �洢sql��������
		TableInfo ti = TableContext.poClassTabelMap.get(c);
		StringBuilder sql = new StringBuilder("insert into " + ti.getTname() + " (");

		Field[] fs = c.getDeclaredFields();
		int countVaildNotNullField = 0; // ���㲻Ϊ��ֵ��������
		for (Field f : fs) {
			String fName = f.getName();
			Object fValue = ReflectUtils.invokeGet(fName, obj);

			if (fValue != null) {
				countVaildNotNullField++;
				sql.append(fName + ",");
				params.add(fValue);
			}
		}
		sql.setCharAt(sql.length() - 1, ')');
		sql.append(" values (");
		for (int i = 0; i < countVaildNotNullField; i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length() - 1, ')');
		executeDML(sql.toString(), params.toArray());
	}

	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��м�¼��ָ������ֵid�ļ�¼��
	 * 
	 * @param clazz
	 *            �����Ӧ�����Class����
	 * @param id
	 *            ����idֵ
	 */
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2

		// ͨ��Class������Tableinfo
		TableInfo tableInfo = TableContext.poClassTabelMap.get(clazz);
		// ��õ�����
		ColumnInfo onlyPK = tableInfo.getOnlyPriKey();

		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPK.getName() + "=? ";

		executeDML(sql, new Object[] { id });
	}

	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼�������������Ӧ���������������ֵ��Ӧ����¼��
	 * 
	 * @param obj
	 */
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTabelMap.get(c);
		ColumnInfo onlyPK = tableInfo.getOnlyPriKey();// ����

		Object PKValue = ReflectUtils.invokeGet(onlyPK.getName(), obj);

		delete(c, PKValue);
	}

	/**
	 * ���¶����Ӧ�ļ�¼������ֻ����ָ�������Ե�ֵ
	 * 
	 * @param obj
	 * 
	 *            ��Ҫ���µĶ���
	 * @param fieldNames
	 *            ���µ������б�
	 * @return ִ��sql���Ӱ���¼������
	 */
	public int update(Object obj, String[] fieldNames) {
		// TODO Auto-generated method stub
		// obj{"uname","age"}--> update ���� set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		ArrayList<Object> params = new ArrayList<Object>(); // �洢sql�Ĳ�������
		TableInfo tableInfo = TableContext.poClassTabelMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey(); // ���Ψһ������
		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");

		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname + "=?,");
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName() + "=? ");

		params.add(ReflectUtils.invokeGet(priKey.getName(), obj)); // ������ֵ

		return executeDML(sql.toString(), params.toArray());
	}

	/**
	 * ��ѯ���ض��м�¼������ÿ�м�¼��װ��clazzָ������Ķ�����
	 * 
	 * @param sql
	 *            ��ѯ���
	 * @param clazz
	 *            ��װ���ݵ�javabean���Class����
	 * @param params
	 *            sql����
	 * @return ��ѯ���Ľ��
	 */
	public ArrayList<Object> queryRows(final String sql, final Class clazz, final Object[] params) {

		return (ArrayList<Object>)executeQueryTempalte(new CallBack() {
			@Override
			public ArrayList<Object> doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				// TODO Auto-generated method stub

				ArrayList<Object> list =null;
				try {
					ResultSetMetaData metaData;
					metaData = rs.getMetaData();
					while (rs.next()) {
						if (list==null) {
							list = new ArrayList<Object>();
							
						}
						Object rowObject = clazz.newInstance(); // ����javabean���޲ι�����

						// ���� select username,pwd,age from user where id=? and age>18
						for (int i = 0; i < metaData.getColumnCount(); i++) {
							String fieldName = metaData.getColumnLabel(i + 1); // username
							Object columnValue = rs.getObject(i + 1);

							// ����rowObject��setUsername����,��columnValue��ֵ���ý�ȥ
							ReflectUtils.invokeSet(rowObject, fieldName, columnValue);

						}
						list.add(rowObject);
					}
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;

			}
		}, sql, params, clazz);
	}

	/**
	 * ����һ�м�¼��������¼��װ��clazzָ������Ķ���
	 * 
	 * @param sql��ѯ���
	 * @param clazz
	 *            ��װ���ݵ�javabean���Class����
	 * @param params
	 *            sql����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		ArrayList<Object> list = queryRows(sql, clazz, params);

		return (list != null && list.size() > 0) ? list.get(0):null;
	}

	/**
	 * ��ѯ����һ��ֵ��һ��һ�У�������ֵ����
	 * 
	 * @param sql
	 *            sql��ѯ���
	 * @param params
	 *            sql����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql, Object[] params) {

		// TODO Auto-generated method stub
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		Object value = null; // ��Ų�ѯ����Ķ���
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// ��sql���ò���
			JDBCUtils.handleParams(ps, params);
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			// ����
			while (rs.next()) {
				// select count(*) from user
				value = rs.getObject(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return value;
	}

	/**
	 * ��ѯ����һ�����֣�һ��һ�У�������ֵ����
	 * 
	 * @param sql
	 *            sql��ѯ���
	 * @param params
	 *            sql����
	 * @return ��ѯ���Ľ��
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageNum
	 *            �ڼ�ҳ����
	 * @param size
	 *            ÿҳ��ʾ��������¼
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
