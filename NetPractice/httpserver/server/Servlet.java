package server;

public class Servlet {
	public void service(Request req,Response rep) {
		rep.print("<html><head><title>HTTP��Ӧʵ��</title>");
		rep.print("</head><body>");
		rep.print("��ӭ��").print(req.getParameter("uname")).print("����!");
		rep.print("</body></html>");
	}
}
