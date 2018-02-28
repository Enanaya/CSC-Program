package utils;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 封装了JDBC查询常用的操作
 * @author 非洲
 *
 */
public class JDBCUtils {
	static Properties pros=null;  //帮助读取资源和处理
	static { //在加载jdbcutil类时调用
		pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getMysqlConnection() {
		try {
			
			//类加载
			Class.forName(pros.getProperty("mysqlDriver"));
			//建立链接
			return DriverManager.getConnection(pros.getProperty("myjdbcUrl"),
					pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//也可以提供重载
	public static void close(ResultSet rs,Statement ps,Connection conn) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**给sql设置参数
	 * @param ps 预编译sql语句对象
	 * @param params 参数
	 */
	public static void handleParams(PreparedStatement ps,Object[] params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				try {
					ps.setObject(1 + i, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
