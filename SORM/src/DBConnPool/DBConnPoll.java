package DBConnPool;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import core.DBManager;

/**
 * 连接池的类
 * 
 * @author 76500
 *
 */
public class DBConnPoll {
	private ArrayList<Connection> pool; // 连接池对象
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();

	/**
	 * 初始化连接池，使池中的连接数达到最小值
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
	 * 从连接池中取出一个连接
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
	 * 相当于将连接放回池中
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
