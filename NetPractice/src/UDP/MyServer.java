package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 76500
 * �����
 * 1.��������˼Ӷ˿�
 * 2.��������
 * 3.��װ�ɰ�
 * 4.��������
 * 5.��������
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		//��������˼Ӷ˿�
		DatagramSocket sever=new DatagramSocket(8888);
		//��������
		byte[]	container=new byte[1024];
		//��װ�ɰ�
		DatagramPacket packet=new DatagramPacket(container, container.length);
		//��������
		sever.receive(packet);
		//��������
		byte[] data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
	}
}
