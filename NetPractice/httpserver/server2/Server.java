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
 * ����������������
 * 
 * 1.����
 * 2.��Ӧ
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
	//��������
	public void start() {
		start(8888);
	}
	
	/**
	 * @param port
	 * ָ���˿ڵ���������
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
	
	//���ܿͻ���
	private void receive() {
		try {
			while(!isShutDown) {
			client= server.accept();
			//����
			new Thread(new Dispactcher(server.accept())).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//ֹͣ
	public void stop() {
		isShutDown=true;
		CloseUtil.closeSocket(client);
	}
}


