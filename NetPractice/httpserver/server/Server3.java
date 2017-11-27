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
public class Server3 {
	private ServerSocket server;
	private Socket client;
	public static final String CRLF="\r\n";
	public static final String BLANK="";
	
	public static void main(String[] args) {
		Server3 server=new Server3()	;
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
			byte[] data=new byte[20480];
			client.getInputStream().read(data);
			
			msg=new String(data,0,data.length).trim();
			System.out.println(msg);
			
			
			//响应
			
			StringBuilder responseContent=new StringBuilder();
			responseContent.append("<html><head><title>HTTP响应实例</title>"+
			"</head><body>Hello Tomcat!</body></html>");
			
			StringBuilder response=new StringBuilder();
			//1.HTTP协议版本，状态代码，描述
			response.append("HTTP/1.1").append(BLANK).append("200").
			append(BLANK).append("OK").append(CRLF);
			//2.响应头
			response.append("Server:bjxst Server/0.0.1").append(CRLF);
			response.append("Date").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//正文长度 字节长度
			response.append("Content-Length:").
			append(responseContent.toString().getBytes().length).append(CRLF);
			//3.正文之前
			response.append(CRLF);
			//4.正文
			response.append(responseContent);
			
			
			//输出
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//停止
	public void stop() {
		
	}
}


