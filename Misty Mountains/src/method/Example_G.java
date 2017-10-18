package method;

import java.util.ArrayList;

import member.Climber_Mountain;

public class Example_G {

	ArrayList<Climber_Mountain> cm_example;

	

	public Example_G() {
		// TODO Auto-generated constructor stub
		cm_example = new ArrayList<Climber_Mountain>() ;
		
		cm_example.add(new Climber_Mountain(01, "Mike", "A", 1892));
		cm_example.add(new Climber_Mountain(02, "John", "B", 528));
		cm_example.add(new Climber_Mountain(03, "Andy", "C", 999));
		cm_example.add(new Climber_Mountain(04, "Mike", "A", 2001));
	}

	public ArrayList<Climber_Mountain> getcm() {
		// TODO Auto-generated method stub
		return cm_example;
	}
}
