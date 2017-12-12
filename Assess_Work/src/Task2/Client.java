package Task2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Client implements Comparable<Client> {
	private String surname;
	private String firstname;
	private int event_most = 0; // can not more than 3
	private ArrayList<Event> eventOwn;

	public Client(String firstname, String surname) {
		super();
		this.surname = surname.trim();
		this.firstname = firstname;
		eventOwn = new ArrayList<Event>();
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

	/**
	 * @param name event_name
	 * @param ticket_amount
	 * when a client buy a or more tickets,add the information into this client 
	 */
	public void addEvent(String name, int ticket_amount) {
		if (event_most < 3) {
			this.eventOwn.add(new Event(name, ticket_amount));
			event_most++;
		} else {
			System.out.println("this client can not have tickets for more than 4 kinds of events");
		}
	}

	/**
	 * @param name
	 * @param amount
	 * when a client cancel a or more tickets,update the information into this client
	 */
	public void ticketCancle_C(String name, int amount) {
		int removeC = -1;
		for (Event event : eventOwn) {
			if (event.getName().equals(name)) {
				if (event.getT_number() < amount) {
					System.out.println("this client doesn't have so much tickets for this event!");
				} else {
					event.ticketMinusInClient(amount);
					removeC++;
					break;
				}
			}
		}
		if (eventOwn.get(removeC).getT_number() == 0) {
			eventOwn.remove(removeC);
		}

	}

	/**
	 * @param eName
	 * while client fail to buy ticket because of not enough ticket,print the info into a file
	 */
	public void infoClient(String eName) {
		// TODO Auto-generated method stub
		try {
			File file=new File(System.getProperty("user.dir") + "/src/Task2/info_letter.txt");
			PrintWriter pw=new PrintWriter(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			pw.write("");
			pw.append("Dear ").append(this.firstname+" "+surname+":\r\n\r\n");
			pw.append("So sorry that tickets for "+eName+" are not available.\r\n");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		// compare by client's surname,if meet same surname,then compare first name
		int res;
		res = this.getSurname().compareTo(o.getSurname());
		if (res == 0) {
			res = this.getFirstname().compareTo(o.getFirstname());
		}
		return res;
	}

}
