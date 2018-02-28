package DBConnPool;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import core.DBManager;

/**
 * ���ӳص���
 * 
 * @author 76500
 *
 */
public class DBConnPoll {
	private ArrayList<Connection> pool; // ���ӳض���
	/**
	 * ���������
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * ��С������
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();

	/**
	 * ��ʼ�����ӳأ�ʹ���е��������ﵽ��Сֵ
	 */
	public void initPool() {
		if (pool == null) {
			pool = new ArrayList<Connection>();
		}

		while (pool.size() < POOL_MIN_SIZE) {
			pool.add(DBManager.createConnection());
		}
	}

	/**
	 * �����ӳ���ȡ��һ������
	 * 
	 * @return
	 */
	public synchronized Connection getConnection() {
		int lastIndex = pool.size() - 1;
		Connection conn = pool.get(lastIndex);
		pool.remove(conn);

		return conn;
	}

	/**
	 * �൱�ڽ����ӷŻس���
	 * 
	 * @param conn
	 */
	public synchronized void close(Connection conn) {
		if (pool.size() >= POOL_MAX_SIZE) {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			pool.add(conn);
		}
	}

	public DBConnPoll() {
		// TODO Auto-generated constructor stub
		initPool();
	}
}
