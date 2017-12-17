package prototype;

import java.util.Date;


public class Sheep2  implements Cloneable{ 
	private String name;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object object=super.clone();
		//添加如下代码实现深复制
		Sheep2 s=(Sheep2) object;
		s.birthday=(Date) this.birthday.clone();
		
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
	public Sheep2(String name,Date date) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.birthday= date;
	}
}
