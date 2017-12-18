package server3;

import java.util.ArrayList;

import javax.xml.namespace.QName;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler {
	private ArrayList<Entity> entities;
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public ArrayList<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(ArrayList<Mapping> mappings) {
		this.mappings = mappings;
	}

	private Entity entity;
	private Mapping mapping;
	private ArrayList<Mapping> mappings;
	private String beginTag;

	private boolean isMap;

	public static void main(String[] args) {

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		entities = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (null != qName) {
			beginTag = qName;

			if (qName.equals("servlet")) {
				isMap = false;
				entity = new Entity();
			} else if (qName.equals("servlet-mapping")) {
				isMap = true;
				mapping = new Mapping();
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if (null!=qName) {
			if (qName.equals("servlet")) {
				entities.add(entity);
			} else if (qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		beginTag=null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if (null != beginTag) {
			String str = new String(ch, start, length);
			if (isMap) {
				if (beginTag.equals("servlet-name") && !beginTag.contains("\n")) {
					mapping.setName(str);
				} else if (beginTag.equals("url-pattern") && !beginTag.contains("\n")) {
					mapping.getUrlPattern().add(str);
				} else if (beginTag.equals("servlet-name") && !beginTag.contains("\n")) {
					entity.setName(str);
				}
			} else if (beginTag.equals("servlet-class") && !beginTag.contains("\n")) {
				entity.setClz(str);
			}
		}
	}
}
