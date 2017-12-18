package server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import util.CloseUtil;

/**
 * @author 76500 封装响应信息
 */
public class Response {
	public static final String CRLF = "\r\n";
	public static final String BLANK = "";
	//构建流
	private BufferedWriter bw;
	
	//正文
	private StringBuilder content;

	// 存储头信息
	private StringBuilder headinfo;
	// 存储正文长度
	private int len = 0;

	public Response() {
		// TODO Auto-generated constructor stub
		headinfo = new StringBuilder();
		len = 0;
		content=new StringBuilder();
	}
	
	public Response(OutputStream os) {//其实传client也可以
		// TODO Auto-generated constructor stub
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	/**
	 * 构建正文+回车
	 * @return 
	 */
	public Response print(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}

	/**
	 * 构建响应头
	 */
	private void conHeadInfo(int code) {
		// 1.HTTP协议版本，状态代码，描述
		headinfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch (code) {
		case 200:
			headinfo.append("OK");
			break;
		case 404:
			headinfo.append("NOT FOUND");
			break;
		case 500:
			headinfo.append("SERVER ERROR");
			break;
		default:
			break;
		}
		headinfo.append(CRLF);
		// 2.响应头
		headinfo.append("Server:bjxst Server/0.0.1").append(CRLF);
		headinfo.append("Date").append(new Date()).append(CRLF);
		headinfo.append("Content-type:text/html;charset=GBK").append(CRLF);
		// 正文长度 字节长度
		headinfo.append("Content-Length:").append(len).append(CRLF);
		headinfo.append(CRLF); //分割符
	}
	
	//推送到客户端
	void pushToClient(int code) throws IOException {
		if (headinfo==null) {
			code=500;
		}
		conHeadInfo(code);
		//头信息+分割符
		bw.append(headinfo.toString());
		//正文
		bw.append(content.toString());
		bw.flush();
	}
	
	public void close() {
		CloseUtil.closeAll(bw);
	}
}
