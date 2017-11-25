package TCP.chat.demo03;

import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * @author 76500 1.创建服务器
 */
public class Server {

	private ArrayList<MyChannel> all=new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Server().start();

	}

	private void start() throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while (true) {
			Socket socket = server.accept();
			// 写出数据
			// 输入流
			MyChannel myChannel = new MyChannel(socket);
			all.add(myChannel);
			new Thread(myChannel).start(); //一条道路
		}
	}
	/**
	 * @author 76500 一个客户端代表一条道路 1.输入流 2.输出流 3.接收数据 4.发送数据
	 */
	/**
	 * @author 76500
	 *
	 */
	private class MyChannel implements Runnable {
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;

		public MyChannel(Socket client) {
			// TODO Auto-generated constructor stub
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				CloseUtil.closeAll(dis, dos);
				isRunning = false;
				all.remove(this);//出异常移除自身
				
			}

		}

		/**
		 * 读取数据
		 * 
		 * @return
		 */
		private String read() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				CloseUtil.closeAll(dis);
				all.remove(this);//出异常移除自身
			}
			return msg;
		}

		/**
		 * 发送数据
		 * 
		 * @param msg
		 */
		private void send(String msg) {
			if (msg == null || msg.equals("")) {
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				CloseUtil.closeAll(dos);
				all.remove(this);//出异常移除自身
			}
		}
		/**
		 * 发送给其他客户端
		 */
		private void sendOthers() {
			String msg=read();
			//遍历容器
			for (MyChannel myChannel : all) {
				if (myChannel==this) {
					continue;
				}
				//发送给其他客户端
				myChannel.send(msg);
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isRunning) {

				sendOthers();
			}
		}

	}
}