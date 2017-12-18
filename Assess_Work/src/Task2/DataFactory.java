package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Task1.SortedArrayList;

/**
 * @author Africo Liang
 * get the operation from class Main_Menu then process data
 */
public class DataFactory {
	Scanner sc;
	int eventCount; //to read and store how many events in system
	int clientCount; //to read and store how many clients in system
	SortedArrayList<Event> eventList = new SortedArrayList<Event>();
	SortedArrayList<Client> clientlist = new SortedArrayList<Client>();
	File readFile;
	public static final String CRLF = "\r\n";

	/**
	 * while initialize this class,call method read to read data from file
	 * "Info_File.txt" which is stored in current work path
	 */
	public DataFactory() {
		read();
	}

	/**
	 * read data and process,transform into client and event
	 */
	public void read() {
		// this try catch part read the data from file
		try {
			readFile = new File(System.getProperty("user.dir") + "/src/Task2/Info_File.txt");
			if (readFile.length() == 0) {
				System.out.println("No content in file!");
				return;
			} else {
				sc = new Scanner(new FileReader(readFile));
				eventCount = Integer.valueOf(sc.nextLine());// read the first line to get the number of events
				int readeventCount = eventCount; // replace it in read loop
				while (sc.hasNextLine() && readeventCount > 0) {
					String Ename = sc.nextLine();
					int Enum = sc.nextInt();
					sc.nextLine();
					eventList.add(new Event(Ename, Enum));
					readeventCount--;
				}

				/*
				 * deal with the ciletn data,spilt the string of whole line then set the string
				 * in[0]and[1] as client's name;the rest part should be event and ticket bought
				 * by cilent 3 condition that 1 kind of event,then 2 and 3
				 */
				clientCount = sc.nextInt();// another to read one line of number
				int readclientCount = clientCount; // replace it in read loop
				sc.nextLine();
				while (sc.hasNextLine() && readclientCount > 0) {
					String[] str = sc.nextLine().split(" ");
					//transform the first and second string as client
					Client current = new Client(str[0], str[1]); 

					/* 
					 * read the info in client,spilt into array,
					 * if length<2,means it hasn't buy any ticket
					 * else if length=4,buy ticket for one event
					 * else if length=6,buy ticket for two events
					 * else if length=8,buy ticket for three events
					 */
					if (str.length > 2) {
						if (str.length == 4) {
							current.addEvent(str[2], Integer.valueOf(str[3]));
						}
						if (str.length == 6) {
							current.addEvent(str[2], Integer.valueOf(str[3]));
							current.addEvent(str[4], Integer.valueOf(str[5]));
						}
						if (str.length == 8) {
							current.addEvent(str[2], Integer.valueOf(str[3]));
							current.addEvent(str[4], Integer.valueOf(str[5]));
							current.addEvent(str[6], Integer.valueOf(str[7]));
						}
					}
					clientlist.add(current);
					readclientCount--;
				}
				sc.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * after input "f" during main menu, store the data into info_File then
	 * terminate the program
	 */
	public void write() {
		File outfile = new File(System.getProperty("user.dir") + "/src/Task2/Info_File1.txt");
		if (!outfile.exists()) {
			try {
				outfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// rewrite the data into file
		try {
			sc = new Scanner(new FileReader(readFile));
			PrintWriter outsc = new PrintWriter(new FileWriter(outfile));
			outsc.write("");
			outsc.write(sc.nextInt() + CRLF); // write the number of event
			sc.nextLine();

			while (sc.hasNextLine() && eventCount > 0) {
				for (Event event : eventList) {
					outsc.append(event.getName() + CRLF + event.getT_number() + CRLF);
					// outsc.append(event.getT_number() + CRLF);
					eventCount--;
				}
			}
			outsc.append(String.valueOf(clientCount) + CRLF);
			while (sc.hasNextLine() && clientCount > 0) {
				for (Client client : clientlist) {
					outsc.append(client.getFirstname() + " " + client.getSurname() + " ");
					// check the bug if null
					for (Event eventinC : client.getEventOwn()) {
						outsc.append(eventinC.getName() + " " + eventinC.getT_number() + " ");
					}
					if (clientCount > 1) {
						outsc.append(CRLF);
					}
					clientCount--;
				}
			}

			outsc.flush();
			outsc.close();
			sc.close();
			// replace the file
			String path = readFile.getAbsolutePath();
			readFile.delete();
			outfile.renameTo(new File(path));
			// outfile.renameTo(new File(System.getProperty("user.dir") +
			// "/src/Task2/Input_File"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SortedArrayList<Event> getEventList() {
		return this.eventList;
	}

	/**
	 * print out the current data of all events
	 */
	public void printEvent() {
		// TODO Auto-generated method stub
		for (Event event : eventList) {
			System.out.println(String.format("%-30s", event.getName()) + event.getT_number());
		}
		System.out.println();
	}

	/**
	 * print out the current data of all clients
	 */
	public void printClient() {
		// TODO Auto-generated method stub
		for (Client clients : clientlist) {
			System.out.print(clients.getFirstname() + " " + clients.getSurname() + "\t");
			clients.getEventOwn().forEach(n -> System.out.print(n.getName() + " " + n.getT_number() + " "));
			System.out.println();
		}
		System.out.println();
	}

	public SortedArrayList<Client> getClientsList() {
		return this.clientlist;
	}

	/**
	 * @param clientFirName
	 * @param clientSurName
	 * @param eventName
	 * @param amount handle the operation of buying ticket,call method in client and event
	 */
	public void buyTicket(String clientFirName, String clientSurName, String eventName, int amount) {
		// TODO Auto-generated method stub
		// Cmatchflag: 0->no client ; 1->client matched ;
		// EmatchFlag: 0->no event ; 1->event matched
		boolean CmatchFlag = false;
		boolean EmatchFlag = false;

		int clientIndex = 0;
		for (Client client : clientlist) {
			if (client.getSurname().equals(clientSurName) && client.getFirstname().equals(clientFirName)) {
				clientIndex = clientlist.indexOf(client);
				CmatchFlag = true;
				break;
			}
		}

		int eventIndex = 0;
		for (Event event : eventList) {
			if (event.getName().equals(eventName)) {
				EmatchFlag = true;
				eventIndex = eventList.indexOf(event);
				break;
			}
		}

		if (EmatchFlag && CmatchFlag) {
			boolean enoughF = eventList.get(eventIndex).buyTicket(amount);
			if (enoughF) {
				clientlist.get(clientIndex).addEvent(eventName, amount);
			} else {
				clientlist.get(clientIndex).infoClient(eventName);
			}
		}

		getIllegalMsg(CmatchFlag, EmatchFlag);
	}

	/**
	 * @param clientFirName
	 * @param clientSurName
	 * @param eventName
	 * @param amount
	 * handle the operation of canceling ticket,call method in client and
	 * event
	 */
	public void cancelTicket(String clientFirName, String clientSurName, String eventName, int amount) {
		// TODO Auto-generated method stub
		// Cmatchflag: 0->no client ; 1->client matched ;
		// EmatchFlag: 0->no event ; 1->event matched
		boolean CmatchFlag = false;
		boolean EmatchFlag = false;

		int clientIndex = 0;
		for (Client client : clientlist) {
			if (client.getSurname().equals(clientSurName) && client.getFirstname().equals(clientFirName)) {
				clientIndex = clientlist.indexOf(client);
				CmatchFlag = true;
				break;
			}
		}

		int eventIndex = 0;
		for (Event event : eventList) {
			if (event.getName().equals(eventName)) {
				eventIndex = eventList.indexOf(event);
				EmatchFlag = true;
				break;
			}
		}

		if (EmatchFlag && CmatchFlag) {
			if (clientlist.get(clientIndex).getEventOwn().size() == 0) {
				System.out.println("this client haven't any ticket");
			}
			for (Event event : clientlist.get(clientIndex).getEventOwn()) {
				if (event.getName().equals(eventName)) {
					if (clientlist.get(clientIndex).ticketCancleInClient(eventName, amount)) {
						eventList.get(eventIndex).cancleTicket(amount);
					}
					break;
				}
			}
		}

		getIllegalMsg(CmatchFlag, EmatchFlag);
	}

	/**
	 * while get illegal input,print the msg out
	 * @param Cflag judge whether get illegal client
	 * @param Eflag judge whether get illegal event
	 */
	public void getIllegalMsg(boolean Cflag, boolean Eflag) {
		if (!Cflag) {
			System.out.println("Illegal cilent!");
		}
		if (!Eflag) {
			System.out.println("Illegal event!");
		}
	}

	/**
	 * while client choose a event to buy ticket,show its current,if there is
	 * matched event return true, else return false,back to main menu
	 * 
	 * @param Ename
	 * @return
	 */
	public boolean showpointedTicket(String Ename) {
		boolean Ematchflag = false;
		for (Event event : eventList) {
			if (event.getName().equals(Ename)) {
				System.out.println("current tickets: " + event.getT_number());
				Ematchflag = true;
				break;
			}
		}
		if (!Ematchflag) {
			System.out.println("Illegal event!");
		}
		return Ematchflag;
	}
}
