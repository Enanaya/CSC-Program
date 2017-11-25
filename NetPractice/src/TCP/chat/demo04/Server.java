package TCP.chat.demo04;

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

	private ArrayList<MyChannel> all = new ArrayList<MyChannel>();

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
			new Thread(myChannel).start(); // 一条道路
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
		private String name;

		public MyChannel(Socket client) {
			// TODO Auto-generated constructor stub
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());

				this.name = dis.readUTF();
				this.send("欢迎进入聊天室");
				sendOthers(this.name + "进入了聊天室", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				CloseUtil.closeAll(dis, dos);
				isRunning = false;
				all.remove(this);// 出异常移除自身

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
				all.remove(this);// 出异常移除自身
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
				all.remove(this);// 出异常移除自身
			}
		}

		/**
		 * 发送给其他客户端
		 */
		private void sendOthers(String msg, boolean sys) {
			// 遍历容器
			// 查看是否为私聊
			if (msg.startsWith("@") && msg.indexOf(":") > -1) {
				String name = msg.substring(1, msg.indexOf(":"));
				String context = msg.substring(msg.indexOf(":") + 1);
				for (MyChannel myChannel : all) {
					if (myChannel.name.equals(name)) {
						myChannel.send(this.name + "对您说:" + context);
					}
				}
			} else {
				for (MyChannel myChannel : all) {
					if (myChannel == this) {
						continue;
					}
					// 发送给其他客户端
					if (sys) { // 系统信息
						myChannel.send("系统信息:" + msg);
					} else {
						myChannel.send(this.name + "对所有人说" + msg);
					}
				}
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isRunning) {

				// send(read());
				sendOthers(read(), false);
			}
		}

	}
}