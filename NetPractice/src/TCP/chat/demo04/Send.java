package TCP.chat.demo04;

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
	public void send(String msg) {

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
			send(getMessage());
		}

	}
}
