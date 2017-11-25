package TCP.chat.demo04;

import java.awt.event.MouseWheelEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author 76500
 * 创建客户端，发送+接受数据
 * 写出数据
 * 读取数据
 * 输入流与输出流应该独立处理，彼此独立
 * 
 * 加入名称
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("请输入名称");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		if (name.equals("")) {
			return ;
		}
		
		
		Socket client=new Socket("localhost", 9999);
		//输出流
		new Thread(new Send(client,name)).start();
		//输入流
		new Thread(new Receive(client)).start();
		
	}
}
