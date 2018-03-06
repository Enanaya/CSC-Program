package classpackage;

public class Person {

	private Name name;
	private int age;

	public Person(Name name, int age) {
		if (name.length() == 0)
			throw new IllegalArgumentException("empty string");

		if (age < 0)
			throw new IllegalArgumentException("zero age");

		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Person))
			return false;

		Person p = (Person) o;

		return age == p.age && name.equals(p.name);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	
}
