package TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 76500 1.������������ָ���˿� 2.���ܿͻ������� 3.��������+�������� ������������������ͷ���
 *
 */

// ���ܶ���ͻ���

public class MultiServer {
	public static void main(String[] args) throws IOException {
		// ������������ָ���˿� ServerSocket(int port)
		ServerSocket server = new ServerSocket(8888);
		// ���ܿͻ������� ����ʽ
		while (true) {//��ѭ�� һ��acceptһ���ͻ���

			Socket socket = server.accept();
			System.out.println("1���ͻ��˽�������");
			String msg = "��ӭʹ��";

			// Data��
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
	}
}
