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
public class Server3 {
	private ServerSocket server;
	private Socket client;
	public static final String CRLF="\r\n";
	public static final String BLANK="";
	
	public static void main(String[] args) {
		Server3 server=new Server3()	;
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
			
			
			//��Ӧ
			
			StringBuilder responseContent=new StringBuilder();
			responseContent.append("<html><head><title>HTTP��Ӧʵ��</title>"+
			"</head><body>Hello Tomcat!</body></html>");
			
			StringBuilder response=new StringBuilder();
			//1.HTTPЭ��汾��״̬���룬����
			response.append("HTTP/1.1").append(BLANK).append("200").
			append(BLANK).append("OK").append(CRLF);
			//2.��Ӧͷ
			response.append("Server:bjxst Server/0.0.1").append(CRLF);
			response.append("Date").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ĳ��� �ֽڳ���
			response.append("Content-Length:").
			append(responseContent.toString().getBytes().length).append(CRLF);
			//3.����֮ǰ
			response.append(CRLF);
			//4.����
			response.append(responseContent);
			
			
			//���
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	//ֹͣ
	public void stop() {
		
	}
}


