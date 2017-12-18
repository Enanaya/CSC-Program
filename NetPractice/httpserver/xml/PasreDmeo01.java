package xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class PasreDmeo01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// 获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 从解析工厂拿到解析器
		SAXParser parser = factory.newSAXParser();
		// 加载文档注册处理器
		// 编写处理器
		PersonHandler handler=new PersonHandler();
		parser.parse(new File("httpserver/xml/person.xml"), handler);
		List<Person> persons=handler.getPersons();
		persons.forEach(n->System.out.println(n.getName()+"-----"+n.getAge()));
	}
}
