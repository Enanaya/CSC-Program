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
 * ��װ��JDBC��ѯ���õĲ���
 * @author ����
 *
 */
public class JDBCUtils {
	static Properties pros=null;  //������ȡ��Դ�ʹ���
	static { //�ڼ���jdbcutil��ʱ����
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
			
			//�����
			Class.forName(pros.getProperty("mysqlDriver"));
			//��������
			return DriverManager.getConnection(pros.getProperty("myjdbcUrl"),
					pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//Ҳ�����ṩ����
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
	
	/**��sql���ò���
	 * @param ps Ԥ����sql������
	 * @param params ����
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
