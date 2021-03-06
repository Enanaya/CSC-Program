package TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 76500 1.创建服务器，指定端口 2.接受客户端链接 3.发送数据+接收数据 先启动服务端再启动客服端
 *
 */

// 接受多个客户端

public class MultiServer {
	public static void main(String[] args) throws IOException {
		// 创建服务器，指定端口 ServerSocket(int port)
		ServerSocket server = new ServerSocket(8888);
		// 接受客户端链接 阻塞式
		while (true) {//死循环 一个accept一个客户端

			Socket socket = server.accept();
			System.out.println("1个客户端建立链接");
			String msg = "欢迎使用";

			// Data流
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
	}
}
