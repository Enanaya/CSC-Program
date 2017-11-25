package UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 76500
 * �����
 * 1.��������˼Ӷ˿�
 * 2.��������
 * 3.��װ�ɰ�
 * 4.�������� �ֽ�����-->double
 * 5.��������
 */

public class Server {
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
		double data=convert(packet.getData());
		System.out.println(data);
		sever.close();
	}
	
	/**
	 * �ֽ����� +data������
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	public static double convert(byte[] data) throws IOException {
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(data));
		double num=dis.readDouble();
		dis.close();
		return num;
	}
}


