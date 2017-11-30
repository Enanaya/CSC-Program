package Task1;

import Task2.Client;
import Task2.Event;

public class listtest {
	public static void main(String[] args) {
		SortedArrayList<Event> e1 = new SortedArrayList<Event>();
		e1.add(new Event("Tennis",6));
		e1.add(new Event("HandBall",66));
		e1.add(new Event("FootBall",2));
		SortedArrayList<Client> e2 = new SortedArrayList<Client>();
		e2.add(new Client("Emma" , "Williams"));
		e2.add(new Client("Anna" , "Smith"));
		e2.add(new Client("John" , "Williams"));
//		System.out.println("H".compareTo("T"));
		for (Event event : e1) {
			System.out.println(event.getName()+"\t"+event.getT_number());
		}
		
		for (Client clients : e2) {
			System.out.println(clients.getFirstname()+"\t"+clients.getSurname());
		}
	}
}
