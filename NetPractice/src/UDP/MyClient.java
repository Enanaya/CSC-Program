package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * @author 76500
 * �ͻ���
 * 1.�����ͻ���+�˿�
 * 2.׼������
 * 3.���(���͵ص㼰�˿�)
 * 4.����
 * 5.�ͷ�
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//�����ͻ���+�˿�
		DatagramSocket client=new DatagramSocket(6666);
		//׼������
		String msg="udp���";
		byte[] data=msg.getBytes();
		//���
		DatagramPacket packet=new DatagramPacket(data, data.length,new 
				InetSocketAddress("localhost",8888) {
		});
		
		//����
		client.send(packet);
		//�ͷ�
		client.close();
	}
	
}
