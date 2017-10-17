package member;

import java.awt.List;
import java.util.ArrayList;

public class Climber {

	private int age;
	private String gender;
	private ArrayList<Mountain> Mountains;
	private int id;
	private String name;
	
	
	public int getId() { 
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ArrayList<Mountain> getMountains() {
		return Mountains;
	}
	public void setMountains(ArrayList<Mountain> mountains) {
		this.Mountains = mountains;
	}
	
	public Climber(String name, int age, String gender, ArrayList mountains) {
//		super();
		setName(name);
		setAge(age);
		setGender(gender);
		setMountains(mountains);
	}
	
	public Mountain gethighset(ArrayList<Mountain> mountains) {
		Mountain highest_mountain=mountains.get(0);
		for (Mountain mountain2 : mountains) {
			if (mountain2.getHeight()>highest_mountain.getHeight()) {
				highest_mountain=mountain2;
			}
		}
		return highest_mountain;
	}

	
	public int average(ArrayList<Mountain> mountains) {
		int total = 0;
		for (Mountain mountain : mountains) {
			total+=mountain.getHeight();
		}
		return total/mountains.size();
	}

	
	ArrayList<Mountain> pointed_mountains=Mountains;
	public void pointed_mountains(int pointed_height) {
	
		for (Mountain mountain : Mountains) {
			if (mountain.getHeight()>pointed_height) {
				pointed_mountains.add(mountain);
			}
		}
	}
	
}
