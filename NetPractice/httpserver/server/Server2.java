package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableInterceptor.RequestInfo;

/**
 * @author 76500
 * ����������������
 */
public class Server2 {
	private ServerSocket server;
	private Socket client;
	public static void main(String[] args) {
		Server2 server=new Server2()	;
		server.start();
		
	}
	//��������
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ܿͻ���
	private void receive() {
		try {
			client= server.accept();
			String msg=null;//���ܿͻ���������Ϣ
			byte[] data=new byte[20480];
			client.getInputStream().read(data);
			
			msg=new String(data,0,data.length).trim();
			System.out.println(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//ֹͣ
	public void stop() {
		
	}
}


