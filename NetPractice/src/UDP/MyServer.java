package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 76500
 * 服务端
 * 1.创建服务端加端口
 * 2.接受容器
 * 3.封装成包
 * 4.接受数据
 * 5.分析数据
 */
public class MyServer {

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
		byte[] data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
	}
}
