package server2;

import java.io.IOException;
import java.net.Socket;


/**
 * @author 76500
 * һ����������ӦΪһ���˶���
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
		try {
			Servlet serv=WebApp.getServlet(req.getUrl());
			if (null==serv) {
				this.code=404; //
			}
			else {
			serv.service(req, res);		
			}
			res.pushToClient(code); //���͵��ͻ���
		}  catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			this.code=500;
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
