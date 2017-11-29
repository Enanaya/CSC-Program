package Task2;

public class Clients {
	private String surname;
	private String firstname;
	private Event eventOwn;
	public Clients(String firstname, String surname) {
		super();
		this.surname = surname;
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public Event getEventOwn() {
		return eventOwn;
	}
	public void setEventOwn(Event eventOwn) {
		this.eventOwn = eventOwn;
	}
	
	
}
