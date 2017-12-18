package server;

public class Servlet {
	public void service(Request req,Response rep) {
		rep.print("<html><head><title>HTTP响应实例</title>");
		rep.print("</head><body>");
		rep.print("欢迎：").print(req.getParameter("uname")).print("回来!");
		rep.print("</body></html>");
	}
}
