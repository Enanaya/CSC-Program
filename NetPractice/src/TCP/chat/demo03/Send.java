package TCP.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author 76500 发送数据线程
 */
public class Send implements Runnable {

	private BufferedReader console; //控制台输入流
	private DataOutputStream dos; //管道输出流
	private boolean isRunning = true; //线程标识

	public Send() {
		// TODO Auto-generated constructor stub
		console = new BufferedReader(new InputStreamReader(System.in));
	}

	public Send(Socket clients) {
		this();
		try {
			dos = new DataOutputStream(clients.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos, console);
		}
	}

	// 从控制接收数据
	private String getMessage() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 从控制台接受数据再发送
	public void send() {

		String msg = getMessage();
		if (msg != null && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush();// 强制刷新
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
		//线程体
		while (isRunning) {
			send();
		}

	}
}
