package reflect;

import server2.Servlet;

/**
 * @author 76500
 * 创建实例，调用空构造
 */
public class demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz= Class.forName("server2.LoginServlet");
		
		//调用空构造 确保空构造存在
		Servlet ser= (Servlet) clz.newInstance();
		
	}
}
