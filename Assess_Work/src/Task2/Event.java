package Task2;

public class Event implements Comparable<Event>{

	private String name;
	private int T_number;
	public Event(String name, int t_number) {
		super();
		this.name = name;
		T_number = t_number;
	}
	
	public String getName() {
		return name;
	}
	public int getT_number() {
		return T_number;
	}

	public void buyTicket(int amount) {
		if (amount<=this.T_number) {
			this.T_number-=amount;
		}else {
			System.out.println("Current Ticket amount are not enough");
		}
	}
	public void cancleTicket(int amount) {
		this.T_number+=amount;
	}
	
	//method for client to cancle ticket info in itself
	public void ticketMinusInClient(int amount) {
		this.T_number-=amount;
	}
	
	
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		int res=this.getName().substring(0, 1).compareTo(o.getName().substring(0, 1));
		return res;
	}
}
