package Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

	

	public void cancleTicket(int amount) {
		this.T_number += amount;
	}

	// method for client to cancle ticket info in itself
	public void ticketMinusInClient(int amount) {
		this.T_number -= amount;
	}

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		int res = this.getName().substring(0, 1).compareTo(o.getName().substring(0, 1));
		return res;
	}
}
