package reflect;

import server2.Servlet;

/**
 * @author 76500
 * ����ʵ�������ÿչ���
 */
public class demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz= Class.forName("server2.LoginServlet");
		
		//���ÿչ��� ȷ���չ������
		Servlet ser= (Servlet) clz.newInstance();
		
	}
}
