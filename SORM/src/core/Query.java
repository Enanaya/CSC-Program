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
 * 负责查询(对外提供查询的核心类)
 * 
 * @author 非洲
 * 
 */
@SuppressWarnings("all")
public abstract class Query  implements Cloneable{

	/**采用模板方式将JDBC操作封装成模板，以便重用
	 * @param back CallBack的实现类，实现回调
	 * @param sql sql语句
	 * @param params sql参数
	 * @param clazz 记录要封装到的java类
	 * @return
	 */
	public Object executeQueryTempalte(CallBack back, String sql, Object[] params, Class clazz) {
		// TODO Auto-generated method stub
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// 给sql设置参数
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
	 * 查询执行一个DML语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数
	 * @return 执行sql语句影响记录的行数
	 */
	public int executeDML(String sql, Object[] params) {
		// TODO Auto-generated method stub
		Connection conn = DBManager.getConnection();
		int count = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			// 给sql设置参数
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
	 * 将一个对象存储到数据库当中,把对象中不为空的属性往数据库中存储 如果数字为null则为0.
	 * 
	 * @param obj
	 *            要存储的对象
	 */
	public void insert(Object obj) {
		// TODO Auto-generated method stub
		// obj-->表中 insert into 表名 (id,uname,pwd) values(?,?,?)
		Class c = obj.getClass();
		ArrayList<Object> params = new ArrayList<Object>(); // 存储sql参数对象
		TableInfo ti = TableContext.poClassTabelMap.get(c);
		StringBuilder sql = new StringBuilder("insert into " + ti.getTname() + " (");

		Field[] fs = c.getDeclaredFields();
		int countVaildNotNullField = 0; // 计算不为空值属性数量
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
	 * 删除clazz表示类对应的表中记录（指定主键值id的记录）
	 * 
	 * @param clazz
	 *            跟表对应的类的Class对象
	 * @param id
	 *            主键id值
	 */
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2

		// 通过Class对象找Tableinfo
		TableInfo tableInfo = TableContext.poClassTabelMap.get(clazz);
		// 获得的主键
		ColumnInfo onlyPK = tableInfo.getOnlyPriKey();

		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPK.getName() + "=? ";

		executeDML(sql, new Object[] { id });
	}

	/**
	 * 删除对象在数据库中对应的记录（对象所在类对应到表，对象的主键的值对应到记录）
	 * 
	 * @param obj
	 */
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTabelMap.get(c);
		ColumnInfo onlyPK = tableInfo.getOnlyPriKey();// 主键

		Object PKValue = ReflectUtils.invokeGet(onlyPK.getName(), obj);

		delete(c, PKValue);
	}

	/**
	 * 更新对象对应的记录，并且只更新指定的属性的值
	 * 
	 * @param obj
	 * 
	 *            所要更新的对象
	 * @param fieldNames
	 *            更新的属性列表
	 * @return 执行sql语句影响记录的行数
	 */
	public int update(Object obj, String[] fieldNames) {
		// TODO Auto-generated method stub
		// obj{"uname","age"}--> update 表名 set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		ArrayList<Object> params = new ArrayList<Object>(); // 存储sql的参数对象
		TableInfo tableInfo = TableContext.poClassTabelMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey(); // 获得唯一的主键
		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");

		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname + "=?,");
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName() + "=? ");

		params.add(ReflectUtils.invokeGet(priKey.getName(), obj)); // 主键的值

		return executeDML(sql.toString(), params.toArray());
	}

	/**
	 * 查询返回多行记录，并将每行记录封装到clazz指定的类的对象中
	 * 
	 * @param sql
	 *            查询语句
	 * @param clazz
	 *            封装数据的javabean类的Class对象
	 * @param params
	 *            sql参数
	 * @return 查询到的结果
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
						Object rowObject = clazz.newInstance(); // 调用javabean的无参构造器

						// 多列 select username,pwd,age from user where id=? and age>18
						for (int i = 0; i < metaData.getColumnCount(); i++) {
							String fieldName = metaData.getColumnLabel(i + 1); // username
							Object columnValue = rs.getObject(i + 1);

							// 调用rowObject的setUsername方法,将columnValue的值设置进去
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
	 * 返回一行记录，并将记录封装到clazz指定的类的对象
	 * 
	 * @param sql查询语句
	 * @param clazz
	 *            封装数据的javabean类的Class对象
	 * @param params
	 *            sql参数
	 * @return 查询到的结果
	 */
	public Object queryUniqueRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		ArrayList<Object> list = queryRows(sql, clazz, params);

		return (list != null && list.size() > 0) ? list.get(0):null;
	}

	/**
	 * 查询返回一个值（一行一列），并将值返回
	 * 
	 * @param sql
	 *            sql查询语句
	 * @param params
	 *            sql参数
	 * @return 查询到的结果
	 */
	public Object queryValue(String sql, Object[] params) {

		// TODO Auto-generated method stub
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		Object value = null; // 存放查询结果的对象
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// 给sql设置参数
			JDBCUtils.handleParams(ps, params);
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			// 多行
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
	 * 查询返回一个数字（一行一列），并将值返回
	 * 
	 * @param sql
	 *            sql查询语句
	 * @param params
	 *            sql参数
	 * @return 查询到的结果
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNum
	 *            第几页数据
	 * @param size
	 *            每页显示多少条记录
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
