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
 * ����������Ϣ��ά�����Ӷ���Ĺ����������ӹ��ܣ�
 * 
 * @author ����
 *
 */
public class DBManager {
	/**
	 * ������Ϣ
	 */
	private static Configuration conf;
	/**
	 * ���ӳض���
	 */
	private static DBConnPoll pool ;

	static { // ��̬�����
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
		// //�����
		// Class.forName(conf.getDirver());
		// //��������
		// return DriverManager.getConnection(conf.getUrl(),
		// conf.getUser(),conf.getPwd()); //ֱ�ӽ������ӣ������������ӳش������Ч��
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
	 * �����µ�connection����
	 * 
	 * @return
	 */
	public static Connection createConnection() {
		try {

			// �����
			Class.forName(conf.getDirver());
			// ��������
			return DriverManager.getConnection(conf.getUrl(), conf.getUser(), conf.getPwd()); // ֱ�ӽ������ӣ������������ӳش������Ч��
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Ҳ�����ṩ����
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
