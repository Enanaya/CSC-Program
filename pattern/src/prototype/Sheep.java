package prototype;

import java.util.Date;


/**
 * @author 76500
 * …Ó∏¥÷∆≤‚ ‘
 */
public class Sheep  implements Cloneable{ 
	private String name;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object object=super.clone();
		return super.clone();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Sheep(String name,Date date) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.birthday= date;
	}
}
