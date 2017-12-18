package server3;

import java.util.HashMap;
import java.util.Map;

import server2.Servlet;

public class ServletContext {
	// 为每个servlet取个名
	// login -->server2.loginservlet 放包名
	private Map<String, String> servlet;
	// url-->login
	// /log-->login
	// /login-->login
	private Map<String, String> mapping;

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}

	public ServletContext() {
		// TODO Auto-generated constructor stub
		servlet = new HashMap<String, String>();
		mapping = new HashMap<String, String>();
	}
}
