package server2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.omg.PortableInterceptor.RequestInfo;

import util.CloseUtil;

/**
 * @author 76500
 * 创建服务器并启动
 * 
 * 1.请求
 * 2.响应
 */
public class Server {
	private ServerSocket server;
	private Socket client;
	public static final String CRLF="\r\n";
	public static final String BLANK="";
	private boolean isShutDown=false;
	
	
	public static void main(String[] args) {
		Server server=new Server()	;
		server.start();
		
	}
	//启动方法
	public void start() {
		start(8888);
	}
	
	/**
	 * @param port
	 * 指定端口的启动方法
	 */
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			stop();
		}
	}
	
	//接受客户端
	private void receive() {
		try {
			while(!isShutDown) {
			client= server.accept();
			//请求
			new Thread(new Dispactcher(server.accept())).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//停止
	public void stop() {
		isShutDown=true;
		CloseUtil.closeSocket(client);
	}
}


