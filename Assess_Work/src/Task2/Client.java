package Task2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Africo Liang
 * client can compare by surname and first name
 */
public class Client implements Comparable<Client> {
	private String surname;
	private String firstname;
	private int event_most = 0; // can not have tickets to more than 3 kinds event
	private ArrayList<Event> eventOwn; //store client's event that already bought tickets

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
	 * @param Ename event_name
	 * @param ticket_amount
	 * when a client buy a or more tickets,add the information into this client 
	 */
	public void addEvent(String Ename, int ticket_amount) {
		boolean addflag=false; //judge whether client already have ticket of this event by Ename
		boolean isFourthT=false; //judge whether it is the fourth kind of event
		for (Event event : eventOwn) {
			if (event.getName().equals(Ename)) {
				isFourthT=true;
				break;
			}
		}
		if (event_most < 3 || isFourthT) {
			for (Event event : eventOwn) {
				if (event.getName().equals(Ename)) {
					event.setT_number(event.getT_number()+ticket_amount);
					addflag=true;
					break;
				}
			}
			if (!addflag) {
				this.eventOwn.add(new Event(Ename, ticket_amount));
				event_most++;
			}
		} else {
			System.out.println("this client can not have tickets for more than 3 kinds of events");
		}
	}

	/**
	 * @param name
	 * @param amount
	 * when a client cancel a or more tickets,update the information into this client
	 */
	public boolean ticketCancleInClient(String name, int amount) {
		int Eindenx =0; //index of event need to cancel ticket 
		
		for (Event event : eventOwn) {
			if (event.getName().equals(name)) {
				if (event.getT_number() < amount) {
					System.out.println("this client doesn't have so much tickets for this event!");
					return false;
				} else {
					event.ticketMinusInClient(amount);
					Eindenx=eventOwn.indexOf(event);
					break;
				}
			}
		}
		if (eventOwn.get(Eindenx).getT_number() == 0) {
			eventOwn.remove(Eindenx);
		}
		return true;
	}

	/**
	 * @param eName
	 * while client fail to buy ticket because of not enough ticket,print the info into a file
	 */
	public void infoClient(String eName) {
		// TODO Auto-generated method stub
		try {
			File file=new File(System.getProperty("user.dir") + "/src/Task2/info_to_"+
		this.firstname+"_"+this.surname+".txt");
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
