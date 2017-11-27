package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.omg.PortableInterceptor.RequestInfo;

/**
 * @author 76500
 * 创建服务器并启动
 * 
 * 1.请求
 * 2.响应
 */
public class Server5 {
	private ServerSocket server;
	private Socket client;
	public static final String CRLF="\r\n";
	public static final String BLANK="";
	
	public static void main(String[] args) {
		Server5 server=new Server5()	;
		server.start();
		
	}
	//启动方法
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//接受客户端
	private void receive() {
		try {
			client= server.accept();
			String msg=null;//接受客户端请求信息
			//请求
			Request request=new Request(client.getInputStream());
			
			//响应
			
			StringBuilder responseContent=new StringBuilder();
			
			Response res=new Response(client.getOutputStream());
			
			res.print("<html><head><title>HTTP响应实例</title>");
			res.print("</head><body>");
			res.print("欢迎：").print(request.getParameter("uname")).print("回来!");
			res.print("</body></html>");
			res.pushToClient(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//停止
	public void stop() {
		
	}
}


