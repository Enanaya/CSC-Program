package TCP.chat.demo03;

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
		//�����
		new Thread(new Send(client)).start();
		//������
		new Thread(new Receive(client)).start();
		
	}
}
