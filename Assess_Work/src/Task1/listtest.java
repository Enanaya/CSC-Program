package Task1;

import Task2.Event;

public class listtest {
	public static void main(String[] args) {
		SortedArrayList<Event> e1 = new SortedArrayList<Event>();
		e1.add(new Event("Tennis",6));
		e1.add(new Event("HandBall",66));
		e1.add(new Event("FootBall",2));
		for (Event event : e1) {
			System.out.println(event.getName()+"\t"+event.getT_number());
		}
	}
}
