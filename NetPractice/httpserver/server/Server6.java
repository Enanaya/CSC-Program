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
 * ����������������
 * 
 * 1.����
 * 2.��Ӧ
 */
public class Server6 {
	private ServerSocket server;
	private Socket client;
	public static final String CRLF="\r\n";
	public static final String BLANK="";
	
	public static void main(String[] args) {
		Server6 server=new Server6()	;
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
			//����
			Servlet ser=new Servlet();
			Request res=new Request(client.getInputStream());
			Response rep=new Response(client.getOutputStream());
			ser.service(res, rep);
			rep.pushToClient(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//ֹͣ
	public void stop() {
		
	}
}


