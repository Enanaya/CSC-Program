package xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author 76500 存储对象
 */
public class PersonHandler extends DefaultHandler {
	private ArrayList<Person> persons;
	private Person person;
	private String tag;// 记录标签名

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("处理文档开始");
		persons = new ArrayList<Person>();
		tag = null;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("处理文档结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("开始一个元素" + qName);
		if (qName != null) {
			tag = qName;
		}
		if (qName != null && qName.equals("person")) {
			person = new Person();
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		// System.out.println("结束一个元素" + qName);
		if (qName.equals("person")) {
			persons.add(person);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String string = new String(ch, start, length);
		if (null != tag && tag.equals("name") && !string.contains("\n")) {
			person.setName(string);
		} else if (null != tag && tag.equals("age") && !string.contains("\n")) {
			Integer age = Integer.parseInt(string);
			person.setAge(age);
		}

	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

}
