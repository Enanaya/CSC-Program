package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import Task1.SortedArrayList;

public class DataFactory {
	Scanner sc;
	int eventCount;
	int clientCount;
	SortedArrayList<Event> eventList = new SortedArrayList<Event>();
	SortedArrayList<Client> clientlist = new SortedArrayList<Client>();

	// ArrayList<Integer> eventNumList=new ArrayList<Integer>();
	public DataFactory() {
		// TODO Auto-generated constructor stub
		read();
	}

	public void read() {
		try {
			File file = new File(System.getProperty("user.dir") + "/src/Task2/Input_File");
			if (file.length() == 0) {
				System.out.println("No content in file!");
				return;
			} else {
				sc = new Scanner(new FileReader(file));
				eventCount = Integer.valueOf(sc.nextLine());// read the first line to get the number of events
				int readeventCount = eventCount;
				while (sc.hasNextLine() && readeventCount > 0) {
					String Ename = sc.nextLine();
					int Enum = sc.nextInt();
					sc.nextLine();
					eventList.add(new Event(Ename, Enum));
					readeventCount--;
				}

				clientCount = sc.nextInt();// another to read one line of number
				int readclientCount = clientCount;
				sc.nextLine();
				while (readclientCount > 0) {
					String[] str = sc.nextLine().split(" ");
					clientlist.add(new Client(str[0], str[1]));
					readclientCount--;
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write() {
		File file = new File(System.getProperty("user.dir") + "/src/Task2/Input_File");
		try {
			sc = new Scanner(new FileReader(file));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// DataReader dr = new DataReader();
	// dr.read();
	// }

	public SortedArrayList<Event> getEventList() {
		return this.eventList;
	}

	public void printEvent() {
		// TODO Auto-generated method stub
		for (Event event : eventList) {
			System.out.println(String.format("%-30s", event.getName()) + event.getT_number());
		}
	}

	public void printClient() {
		// TODO Auto-generated method stub
		for (Client clients : clientlist) {
			System.out.print(clients.getFirstname() + " " + clients.getSurname() + "\t");
			clients.getEventOwn().forEach(n -> System.out.print(n.getName() + "\t" + n.getT_number()));
			System.out.println();
		}
	}

	public SortedArrayList<Client> getClientsList() {
		return this.clientlist;
	}

	public void buyTicket(String clientFirName, String clientSurName, String eventName, int amount) {
		// TODO Auto-generated method stub
		// Cmatchflag: 0->no client ; 1->client matched ;
		// EmatchFlag: 0->no event ; 1->event matched
		boolean CmatchFlag = false;
		boolean EmatchFlag = false;

		int clientIndex = 0;
		for (int i = 0; i < clientlist.size(); i++) {
			if (clientlist.get(i).getSurname().equals(clientSurName)
					&& clientlist.get(i).getFirstname().equals(clientFirName)) {
				CmatchFlag = true;
				clientIndex = i;
				break;
			}
		}
		int eventIndex = 0;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getName().equals(eventName)) {
				EmatchFlag = true;
				eventIndex = i;
				break;
			}
		}

		if (EmatchFlag && CmatchFlag) {
			eventList.get(eventIndex).buyTicket(amount);
			clientlist.get(clientIndex).addEvent(eventName, amount);
		}

		if (!CmatchFlag) {
			System.out.println("Illegal cilent!");
			System.out.println("press enter to go back menu");
		}
		if (!EmatchFlag) {
			System.out.println("Illegal event!");
			System.out.println("press enter to go back menu");
		}
	}

	public void cancelTicket(String clientFirName, String clientSurName, String eventName, int amount) {
		// TODO Auto-generated method stub
		// Cmatchflag: 0->no client ; 1->client matched ;
		// EmatchFlag: 0->no event ; 1->event matched
		boolean CmatchFlag = false;
		boolean EmatchFlag = false;

		int clientIndex = 0;
		for (int i = 0; i < clientlist.size(); i++) {
			if (clientlist.get(i).getSurname().equals(clientSurName)
					&& clientlist.get(i).getFirstname().equals(clientFirName)) {
				CmatchFlag = true;
				clientIndex = i;
				break;
			}
		}
		int eventIndex = 0;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getName().equals(eventName)) {
				EmatchFlag = true;
				eventIndex = i;
				break;
			}
		}

		if (EmatchFlag && CmatchFlag) {
			for (Event event : clientlist.get(clientIndex).getEventOwn()) {
				if (event.getName().equals(eventName)) {
					eventList.get(eventIndex).cancleTicket(amount);
					clientlist.get(clientIndex).ticketCancle_C(eventName, amount);
					break;
				}
			}
		}

		if (!CmatchFlag) {
			System.out.println("Illegal cilent!");
			System.out.println("press enter to go back menu");
		}
		if (!EmatchFlag) {
			System.out.println("Illegal event!");
			System.out.println("press enter to go back menu");
		}
	}

}
