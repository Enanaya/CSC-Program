package UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author 76500
 * 客户端
 * 1.创建客户端+端口
 * 2.准备数据 double-->字节数组 字节数组输出流
 * 3.打包(发送地点及端口)
 * 4.发送
 * 5.释放
 */

public class Client {
	public static void main(String[] args) throws IOException {
		//创建客户端+端口
		DatagramSocket client=new DatagramSocket(6666);
		//准备数据
		double num=894.23;
		byte[] data=convert(num);
		//打包
		DatagramPacket packet=new DatagramPacket(data, data.length,new 
				InetSocketAddress("localhost",8888) {
		});
		
		//发送
		client.send(packet);
		//释放
		client.close();
	}
	
	
	/**
	 * 字节数组 数据源+ data输出流
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


