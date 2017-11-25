package TCP.chat.demo04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author 76500
 * 专门用于接受线程
 */
public class Receive  implements Runnable{
	private DataInputStream dis;
	private boolean isRunning=true;
	public Receive() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Receive(Socket client) {
		// TODO Auto-generated constructor stub
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
	}
	
	//接收数据
	public String receive() {
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			System.out.println(receive());
		}
	}

}
