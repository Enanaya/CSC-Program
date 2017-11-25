package TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 76500
 * 1.创建客户端,指定服务器+端口，此时就在连接
 * Socket(String host,int port)
 * 2.接收数据+发送数据
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//创建客户端,指定服务器+端口，此时就在连接
		Socket client=new Socket("localhost", 8888);
		//接收数据
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
//		String echo=br.readLine(); //
//		System.out.println(echo);
		
		//data流
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String echo=dis.readUTF();
		System.out.println(echo);
	}

}
