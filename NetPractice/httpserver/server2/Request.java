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
 * @author 76500 封装request
 */
public class Request {
	// 请求方式
	private String method;
	// 请求资源
	private String url;
	// 请求参数
	private Map<String, ArrayList<String>> parameterMapValues;

	// 内部
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
		// 分析请求信息
		parseRequest(requestInfo);
	}

	// 分析请求信息
	private void parseRequest(String requestInfo) {
		// TODO Auto-generated method stub
		if (requestInfo == null || requestInfo.equals("")) {
			return;
		}

		/*
		 * ===================== 从信息里的首行分解出：请求方式 请求路径 请求参数（get 可能存在）
		 * 如：GET/index.html?name=123&pwd=456 HTTP/1.1
		 * 
		 * 如果为post方式，请求参数可能在 最后正文中
		 * 
		 * ===================
		 */
		String paramString = ""; // 接受请求参数
		// 1.获取请求方式
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int idx = firstLine.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();// /的位置
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if (this.method.equalsIgnoreCase("post")) {
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		} else if (this.method.equalsIgnoreCase("get")) {
			if (urlStr.contains("?")) {// 是否存在参数
				String[] urlArray = urlStr.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1]; // 接受请求参数
			} else {
				this.url = urlStr;
			}
		}

		// 如果不存在请求参数
		if (paramString.equals("")) {
			return;
		}
		// 2.将请求参数封装到Map中
		parseParame(paramString);

	}

	private void parseParame(String paramString) {
		// 分割 将字符串转成数组
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
			// 转换成map
			if (!parameterMapValues.containsKey(key)) {
				parameterMapValues.put(key, new ArrayList<String>());
			}
			ArrayList<String> values = parameterMapValues.get(key);
			values.add(value);
		}

	}

	/** 解决中文的问题
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
	 * 根据页面的name获取对应的值
	 */
	public String getParameter(String name) {
		String[] values=getParameterValues(name);
		if (values==null) {
			return null;
		}else {
			return values[0];
		}
	}

	//获取多个值
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
