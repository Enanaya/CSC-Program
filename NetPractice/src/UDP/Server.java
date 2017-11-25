package UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 76500
 * 服务端
 * 1.创建服务端加端口
 * 2.接受容器
 * 3.封装成包
 * 4.接受数据 字节数组-->double
 * 5.分析数据
 */

public class Server {
	public static void main(String[] args) throws IOException {
		//创建服务端加端口
		DatagramSocket sever=new DatagramSocket(8888);
		//接受容器
		byte[]	container=new byte[1024];
		//封装成包
		DatagramPacket packet=new DatagramPacket(container, container.length);
		//接受数据
		sever.receive(packet);
		//分析数据
		double data=convert(packet.getData());
		System.out.println(data);
		sever.close();
	}
	
	/**
	 * 字节数组 +data输入流
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


