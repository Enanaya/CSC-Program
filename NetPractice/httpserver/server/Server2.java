package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableInterceptor.RequestInfo;

/**
 * @author 76500
 * 创建服务器并启动
 */
public class Server2 {
	private ServerSocket server;
	private Socket client;
	public static void main(String[] args) {
		Server2 server=new Server2()	;
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//停止
	public void stop() {
		
	}
}


