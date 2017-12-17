package server;

import java.io.IOException;
import java.net.Socket;

import TCP.chat.demo03.CloseUtil;

/**
 * @author 76500
 * 一个请求与相应为一个此对象
 */
public class Dispactcher implements Runnable{

	Socket client;
	private Request req;
	private Response res;
	private int code=200;
	
	
	public Dispactcher(Socket client) {
		this.client = client;
		try {
			req=new Request(client.getInputStream());
			res=new Response(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			code=500;
			return ;
		}
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		Servlet ser=new Servlet();
		ser.service(req, res);
		try {
			res.pushToClient(code); //推送到客户端
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		try {
			res.pushToClient(500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.CloseUtil.closeSocket(client);
	}

}
