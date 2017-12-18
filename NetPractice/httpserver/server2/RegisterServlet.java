package server2;
import server2.Servlet;

public class RegisterServlet extends Servlet{
	@Override
	public void doGet(Request req,Response res) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void doPost(Request req,Response res) throws Exception {
		// TODO Auto-generated method stub
		res.print("<html><head><title>返回注册</title>");
		res.print("</head><body>");
		res.print("你的用户名为"+req.getParameter("uname"));
		res.print("</body></html>");

	}
}
