package server3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import server3.Servlet;

public class WebApp {
	private static ServletContext context;
	static {

		// �ӽ��������õ�������
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			WebHandler web = new WebHandler();
			parser.parse(new File("httpserver/server3/web.xml"), web);
			
			//��listת��map
			context = new ServletContext();
			Map<String, String> servlet = context.getServlet();
			//servlet-name,class
			for (Entity entity : web.getEntities()) {
				servlet.put(entity.getName(), entity.getClz());
			}
			
			//url-pattern
			Map<String, String> mapping = context.getMapping();
			for (Mapping mapping2 : web.getMappings()) {
				ArrayList<String> urls=mapping2.getUrlPattern();
				for (String url : urls) {
					mapping.put(url, mapping2.getName());
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����ĵ�ע�ᴦ����
		// ��д������
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Servlet getServlet(String url)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (null == url || (url = url.trim()).equals("")) {
			return null;
		}
		// �����ַ�����������

		// return context.getServlet().get(context.getMapping().get(url));
		String name = context.getServlet().get(context.getMapping().get(url));
		return (Servlet) Class.forName(name).newInstance();

	}
}
