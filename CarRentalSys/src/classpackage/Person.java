package classpackage;

import java.util.Date;


public class Person {

	private Name name;
	private Date birthday;

	public Person(Name name, Date birthday) {
		if (name.length() == 0)
			throw new IllegalArgumentException("empty string");
		if (birthday.getTime()<0) {
			throw new IllegalArgumentException("invalid birthday");
		}
		this.name = name;
		this.birthday=birthday;
	}

	

	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Person))
			return false;

		Person p = (Person) o;

		return  name.equals(p.name) && birthday==p.birthday;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
