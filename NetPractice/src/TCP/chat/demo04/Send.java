package TCP.chat.demo04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author 76500 ���������߳�
 */
public class Send implements Runnable {

	private BufferedReader console; //����̨������
	private DataOutputStream dos; //�ܵ������
	private boolean isRunning = true; //�̱߳�ʶ
	private String name;
	
	public Send() {
		// TODO Auto-generated constructor stub
		console = new BufferedReader(new InputStreamReader(System.in));
	}

	public Send(Socket clients,String name) {
		this();
		try {
			dos = new DataOutputStream(clients.getOutputStream());
			this.name=name;
			send(this.name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos, console);
		}
	}

	// �ӿ��ƽ�������
	private String getMessage() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// �ӿ���̨���������ٷ���
	public void send(String msg) {

		if (msg != null && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush();// ǿ��ˢ��
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CloseUtil.closeAll(dos, console);
			}

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//�߳���
		while (isRunning) {
			send(getMessage());
		}

	}
}
