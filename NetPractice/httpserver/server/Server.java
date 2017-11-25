package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 76500
 * 创建服务器并启动
 */
public class Server {
	private ServerSocket server;
	private Socket client;
	public static void main(String[] args) {
		Server server=new Server()	;
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
			StringBuilder sb=new StringBuilder();
			BufferedReader  br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//停止
	public void stop() {
		
	}
}


