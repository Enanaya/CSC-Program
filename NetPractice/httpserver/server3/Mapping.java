package server3;

import java.util.ArrayList;

/**
 * <servlet-mapping>
		<servlet-name>
			login
		</servlet-name>
		<url-patterns>/login</url-patterns>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>
			login
		</servlet-name>
		<url-patterns>/log</url-patterns>
	</servlet-mapping>
 *
 */
public class Mapping {
	private String name;
	private ArrayList<String> urlPattern;
	
	public Mapping() {
		urlPattern=new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(ArrayList<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
	
}
