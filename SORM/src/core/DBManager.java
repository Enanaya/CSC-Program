package core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import DBConnPool.DBConnPoll;
import bean.Configuration;

/**
 * 根据配置信息，维持连接对象的管理（增加连接功能）
 * 
 * @author 非洲
 *
 */
public class DBManager {
	/**
	 * 配置信息
	 */
	private static Configuration conf;
	/**
	 * 连接池对象
	 */
	private static DBConnPoll pool ;

	static { // 静态代码块
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conf = new Configuration();
		conf.setDirver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMinSize")));
	}

	public static Connection getConnection() {
		// try {
		//
		// //类加载
		// Class.forName(conf.getDirver());
		// //建立链接
		// return DriverManager.getConnection(conf.getUrl(),
		// conf.getUser(),conf.getPwd()); //直接建立连接，后期增加连接池处理，提高效率
		// } catch (ClassNotFoundException | SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// return null;
		// }
		if (pool==null) {
			pool=new DBConnPoll();
		}
		return pool.getConnection();
	}

	/**
	 * 创建新的connection对象
	 * 
	 * @return
	 */
	public static Connection createConnection() {
		try {

			// 类加载
			Class.forName(conf.getDirver());
			// 建立链接
			return DriverManager.getConnection(conf.getUrl(), conf.getUser(), conf.getPwd()); // 直接建立连接，后期增加连接池处理，提高效率
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 也可以提供重载
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pool.close(conn);
	}

	public static Configuration getConf() {
		return conf;
	}
}
