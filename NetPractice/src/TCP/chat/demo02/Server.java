package TCP.chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 76500 1.����������
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();
		// д������
		// ������
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		while (true) {
		String msg = dis.readUTF();
		System.out.println(msg);
		// �����
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("������-->"+msg);
		dos.flush();
		}
	}

}
