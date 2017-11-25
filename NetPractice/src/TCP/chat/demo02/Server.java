package TCP.chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 76500 1.创建服务器
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();
		// 写出数据
		// 输入流
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		while (true) {
		String msg = dis.readUTF();
		System.out.println(msg);
		// 输出流
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("服务器-->"+msg);
		dos.flush();
		}
	}

}
