package server3;

import server2.Servlet;

public class LoginServlet extends server3.Servlet {

	@Override
	public void doGet(Request req, Response res) throws Exception {
		// TODO Auto-generated method stub
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		if (login(name, pwd)) {
			res.print("��¼�ɹ�");
		}else {
			res.print("��¼ʧ��");
			
		}
	}

	@Override
	public void doPost(Request req, Response res) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean login(String name, String pwd) {
		return name.equals("bjsxt") && pwd.equals("123456");
	}

}
