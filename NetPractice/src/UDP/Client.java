package UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author 76500
 * �ͻ���
 * 1.�����ͻ���+�˿�
 * 2.׼������ double-->�ֽ����� �ֽ����������
 * 3.���(���͵ص㼰�˿�)
 * 4.����
 * 5.�ͷ�
 */

public class Client {
	public static void main(String[] args) throws IOException {
		//�����ͻ���+�˿�
		DatagramSocket client=new DatagramSocket(6666);
		//׼������
		double num=894.23;
		byte[] data=convert(num);
		//���
		DatagramPacket packet=new DatagramPacket(data, data.length,new 
				InetSocketAddress("localhost",8888) {
		});
		
		//����
		client.send(packet);
		//�ͷ�
		client.close();
	}
	
	
	/**
	 * �ֽ����� ����Դ+ data�����
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data=null;
		ByteArrayOutputStream boStream=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(boStream);
		dos.writeDouble(num);
		dos.flush();
		data=boStream.toByteArray();
		dos.close();
		return data;
	}
}


