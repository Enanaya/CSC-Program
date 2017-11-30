package Task2;

import java.util.ArrayList;

public class Client implements Comparable<Client>{
	private String surname;
	private String firstname;
	private int event_most=0; //can not more than 3
	private ArrayList<Event> eventOwn;
	public Client(String firstname, String surname) {
		super();
		this.surname = surname;
		this.firstname = firstname;
		eventOwn=new ArrayList<Event>();
	}
	public String getSurname() {
		return surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public ArrayList<Event> getEventOwn() {
		return eventOwn;
	}
	
	public void addEvent(String name,int ticket_amount) {
		if (event_most<3) {
			this.eventOwn.add(new Event(name, ticket_amount));
			event_most++;
		}else {
			System.out.println("this client can not have tickets for more than 4 kinds of events");
		}
	}
	
	public void ticketCancle_C(String name,int amount) {
		int removeC=-1;
		for (Event event : eventOwn) {
			if (event.getName().equals(name)) {
				if (event.getT_number()<amount) {
					System.out.println("this client doesn't have so much tickets for this event!");
				}else {
					event.ticketMinusInClient(amount);
					removeC++;
					break;
				}
			}
		}
		if (eventOwn.get(removeC).getT_number()==0) {
			eventOwn.remove(removeC);
		}
		
	}
	
	
	@Override
	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		int res;
		res=this.getSurname().compareTo(o.getSurname());
		if (res==0) {
			res=this.getFirstname().compareTo(o.getFirstname());
		}
		return res;
	}
	
	
}
