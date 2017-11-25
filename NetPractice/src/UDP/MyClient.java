package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * @author 76500
 * 客户端
 * 1.创建客户端+端口
 * 2.准备数据
 * 3.打包(发送地点及端口)
 * 4.发送
 * 5.释放
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//创建客户端+端口
		DatagramSocket client=new DatagramSocket(6666);
		//准备数据
		String msg="udp编程";
		byte[] data=msg.getBytes();
		//打包
		DatagramPacket packet=new DatagramPacket(data, data.length,new 
				InetSocketAddress("localhost",8888) {
		});
		
		//发送
		client.send(packet);
		//释放
		client.close();
	}
	
}
