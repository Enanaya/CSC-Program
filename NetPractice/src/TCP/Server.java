package TCP;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 76500
 * 1.������������ָ���˿�
 * 2.���ܿͻ�������
 * 3.��������+��������
 * ������������������ͷ���
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//������������ָ���˿� ServerSocket(int port)
		ServerSocket server=new ServerSocket(8888);
		//���ܿͻ������� ����ʽ
		Socket socket=server.accept();
		System.out.println("1���ͻ��˽�������");
		//�������� 
//		//������
		String msg="��ӭʹ��";
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter( socket.getOutputStream()));
//		bw.write(msg);
//		bw.newLine();
//		bw.flush();
		
		//Data��
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
	}
}
