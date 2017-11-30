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
 * @author 76500 1.����������
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
			// д������
			// ������
			MyChannel myChannel = new MyChannel(socket);
			all.add(myChannel);
			new Thread(myChannel).start(); // һ����·
		}
	}

	/**
	 * @author 76500 һ���ͻ��˴���һ����· 1.������ 2.����� 3.�������� 4.��������
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
				this.send("��ӭ����������");
				sendOthers(this.name + "������������", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				CloseUtil.closeAll(dis, dos);
				isRunning = false;
				all.remove(this);// ���쳣�Ƴ�����

			}

		}

		/**
		 * ��ȡ����
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
				all.remove(this);// ���쳣�Ƴ�����
			}
			return msg;
		}

		/**
		 * ��������
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
				all.remove(this);// ���쳣�Ƴ�����
			}
		}

		/**
		 * ���͸������ͻ���
		 */
		private void sendOthers(String msg, boolean sys) {
			// ��������
			// �鿴�Ƿ�Ϊ˽��
			if (msg.startsWith("@") && msg.indexOf(":") > -1) {
				String name = msg.substring(1, msg.indexOf(":"));
				String context = msg.substring(msg.indexOf(":") + 1);
				for (MyChannel myChannel : all) {
					if (myChannel.name.equals(name)) {
						myChannel.send(this.name + "����˵:" + context);
					}
				}
			} else {
				for (MyChannel myChannel : all) {
					if (myChannel == this) {
						continue;
					}
					// ���͸������ͻ���
					if (sys) { // ϵͳ��Ϣ
						myChannel.send("ϵͳ��Ϣ:" + msg);
					} else {
						myChannel.send(this.name + "��������˵" + msg);
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