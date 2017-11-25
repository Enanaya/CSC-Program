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
 * 创建客户端，发送+接受数据
 * 写出数据
 * 读取数据
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client=new Socket("localhost", 9999);
		//输出流
		new Thread(new Send(client)).start();
		//输入流
		new Thread(new Receive(client)).start();
		
	}
}
