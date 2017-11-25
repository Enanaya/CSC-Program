package TCP.chat.demo01;

import java.awt.event.MouseWheelEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author 76500
 * �����ͻ��ˣ�����+��������
 * д������
 * ��ȡ����
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost", 9999);
		//����̨������
		Scanner sc=new Scanner(System.in);
		while (true) {
			
		String info=sc.nextLine();
		
		//�����
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(info);
		dos.flush();
		
		//������
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String msg=dis.readUTF();
		System.out.println(msg);
		}
	}
}
