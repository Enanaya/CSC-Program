package server2;

import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author 76500 ��װrequest
 */
public class Request {
	// ����ʽ
	private String method;
	// ������Դ
	private String url;
	// �������
	private Map<String, ArrayList<String>> parameterMapValues;

	// �ڲ�
	public static final String CRLF = "\r\n";
	public static final String BLANK = "";
	private InputStream is;
	private String requestInfo;

	public Request() {
		// TODO Auto-generated constructor stub
		method = "";
		url = "";
		parameterMapValues = new HashMap<String, ArrayList<String>>();
		requestInfo="";
	}
	
	public Request(InputStream is) {
		// TODO Auto-generated constructor stub
		this();
		this.is = is;
		byte[] data = new byte[20480];
		int len;
		try {
			len = this.is.read(data);
			requestInfo = new String(data, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}
		// ����������Ϣ
		parseRequest(requestInfo);
	}

	// ����������Ϣ
	private void parseRequest(String requestInfo) {
		// TODO Auto-generated method stub
		if (requestInfo == null || requestInfo.equals("")) {
			return;
		}

		/*
		 * ===================== ����Ϣ������зֽ��������ʽ ����·�� ���������get ���ܴ��ڣ�
		 * �磺GET/index.html?name=123&pwd=456 HTTP/1.1
		 * 
		 * ���Ϊpost��ʽ��������������� ���������
		 * 
		 * ===================
		 */
		String paramString = ""; // �����������
		// 1.��ȡ����ʽ
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int idx = firstLine.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();// /��λ��
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if (this.method.equalsIgnoreCase("post")) {
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		} else if (this.method.equalsIgnoreCase("get")) {
			if (urlStr.contains("?")) {// �Ƿ���ڲ���
				String[] urlArray = urlStr.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1]; // �����������
			} else {
				this.url = urlStr;
			}
		}

		// ����������������
		if (paramString.equals("")) {
			return;
		}
		// 2.�����������װ��Map��
		parseParame(paramString);

	}

	private void parseParame(String paramString) {
		// �ָ� ���ַ���ת������
		StringTokenizer token = new StringTokenizer(paramString, "&");
		while (token.hasMoreElements()) {
			String keyValue = (String) token.nextElement();
			String[] keyValues = keyValue.split("=");
			if (keyValues.length == 1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			String key = keyValues[0].trim();
			String value = (null == keyValues[1] ? null : decode(keyValues[1].trim(),"gbk"));
			// ת����map
			if (!parameterMapValues.containsKey(key)) {
				parameterMapValues.put(key, new ArrayList<String>());
			}
			ArrayList<String> values = parameterMapValues.get(key);
			values.add(value);
		}

	}

	/** ������ĵ�����
	 * @param msg
	 * @param code
	 * @return
	 */
	private String decode(String msg,String code) {
		try {
		 return	URLDecoder.decode(msg, code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ����ҳ���name��ȡ��Ӧ��ֵ
	 */
	public String getParameter(String name) {
		String[] values=getParameterValues(name);
		if (values==null) {
			return null;
		}else {
			return values[0];
		}
	}

	//��ȡ���ֵ
	public String[] getParameterValues(String name) {
		ArrayList<String> values=null;
		if ((values=parameterMapValues.get(name))==null) {
			return null;
		}
		else {
			return values.toArray(new String[0]);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
