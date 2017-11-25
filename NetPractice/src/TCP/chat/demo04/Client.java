package TCP.chat.demo04;

import java.awt.event.MouseWheelEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author 76500
 * �����ͻ��ˣ�����+��������
 * д������
 * ��ȡ����
 * �������������Ӧ�ö��������˴˶���
 * 
 * ��������
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("����������");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		if (name.equals("")) {
			return ;
		}
		
		
		Socket client=new Socket("localhost", 9999);
		//�����
		new Thread(new Send(client,name)).start();
		//������
		new Thread(new Receive(client)).start();
		
	}
}
