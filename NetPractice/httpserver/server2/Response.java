package server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import util.CloseUtil;

/**
 * @author 76500 ��װ��Ӧ��Ϣ
 */
public class Response {
	public static final String CRLF = "\r\n";
	public static final String BLANK = "";
	//������
	private BufferedWriter bw;
	
	//����
	private StringBuilder content;

	// �洢ͷ��Ϣ
	private StringBuilder headinfo;
	// �洢���ĳ���
	private int len = 0;

	public Response() {
		// TODO Auto-generated constructor stub
		headinfo = new StringBuilder();
		len = 0;
		content=new StringBuilder();
	}
	
	public Response(OutputStream os) {//��ʵ��clientҲ����
		// TODO Auto-generated constructor stub
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	/**
	 * ��������+�س�
	 * @return 
	 */
	public Response print(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}

	/**
	 * ������Ӧͷ
	 */
	private void conHeadInfo(int code) {
		// 1.HTTPЭ��汾��״̬���룬����
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
		// 2.��Ӧͷ
		headinfo.append("Server:bjxst Server/0.0.1").append(CRLF);
		headinfo.append("Date").append(new Date()).append(CRLF);
		headinfo.append("Content-type:text/html;charset=GBK").append(CRLF);
		// ���ĳ��� �ֽڳ���
		headinfo.append("Content-Length:").append(len).append(CRLF);
		headinfo.append(CRLF); //�ָ��
	}
	
	//���͵��ͻ���
	void pushToClient(int code) throws IOException {
		if (headinfo==null) {
			code=500;
		}
		conHeadInfo(code);
		//ͷ��Ϣ+�ָ��
		bw.append(headinfo.toString());
		//����
		bw.append(content.toString());
		bw.flush();
	}
	
	public void close() {
		CloseUtil.closeAll(bw);
	}
}
