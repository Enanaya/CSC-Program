package Task2;

/**
 * @author Africo Liang
 * event can compare by its name
 */
public class Event implements Comparable<Event> {

	private String name;
	private int T_number;

	public Event(String name, int t_number) {
		super();
		this.name = name.trim();
		T_number = t_number;
	}

	public String getName() {
		return name;
	}

	public int getT_number() {
		return T_number;
	}
	
	public void setT_number(int t_number) {
		T_number = t_number;
	}

	/**
	 * @param amount
	 * @return true or false
	 * buy tickets and update the current tickets' information
	 */
	public boolean buyTicket(int amount) {
		if (amount <= this.T_number) {
			this.T_number -= amount;
			return true;
		} else {
			System.out.println("Current Ticket amount are not enough");
			// printed a letter in a file to client
			return false;
		}
	}

	/**
	 * @param amount
	 * after a client cancel tickets,update the information of ticket,
	   need add the amount canceled by client to current tickets matching with event
	 */
	public void cancleTicket(int amount) {
		this.T_number += amount;
	}

	/**
	 * @param amount
	 * while client cancel ticket,call this method to minus amount for event matching to client
	 * differ from cancleTicket:this method will be called by client to cancel client's ticket
	 , method cancleTicket do operation after this method to update total amount of tickets
	 */
	public void ticketMinusInClient(int amount) {
		this.T_number -= amount;
	}

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		// compare by event's name
		int res = this.getName().substring(0, 1).compareTo(o.getName().substring(0, 1));
		return res;
	}
}
