package TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 76500
 * 1.�����ͻ���,ָ��������+�˿ڣ���ʱ��������
 * Socket(String host,int port)
 * 2.��������+��������
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//�����ͻ���,ָ��������+�˿ڣ���ʱ��������
		Socket client=new Socket("localhost", 8888);
		//��������
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
//		String echo=br.readLine(); //
//		System.out.println(echo);
		
		//data��
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String echo=dis.readUTF();
		System.out.println(echo);
	}

}
