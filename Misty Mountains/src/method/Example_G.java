package method;

import java.util.ArrayList;

import member.Climber;
import member.Climber_Mountain;
import member.Mountain;

public class Example_G {

	ArrayList<Climber_Mountain> cm_example;
	ArrayList<Climber> climbers;
	ArrayList<Mountain> mountains;
	
	public Example_G() {
		// TODO Auto-generated constructor stub
		cm_example = new ArrayList<Climber_Mountain>() ;  // create climber_mountain example
		
		cm_example.add(new Climber_Mountain(01, "Mike", "A", 1892));
		cm_example.add(new Climber_Mountain(02, "John", "B", 528));
		cm_example.add(new Climber_Mountain(03, "Andy", "C", 999));
		cm_example.add(new Climber_Mountain(04, "Mike", "A", 2001));
		
		climbers=new ArrayList<Climber>();
		climbers.add(new Climber("Mike", 24, "Male"));
		climbers.add(new Climber("John", 16, "Male"));
		climbers.add(new Climber("Andy", 30, "Female"));
		
		mountains=new ArrayList<>(mountains);
		mountains.add(new Mountain("A",3000));
		mountains.add(new Mountain("B",2000));
		mountains.add(new Mountain("C",4000));
	}

	public ArrayList<Climber_Mountain> getcm() {
		// TODO Auto-generated method stub
		return cm_example;
	}
	
	public ArrayList<Climber> getC() {
		return climbers;
	}
	
	public ArrayList<Mountain> getM() {
		return mountains;
	}
}
