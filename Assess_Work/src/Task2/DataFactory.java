package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Task1.SortedArrayList;

public class DataFactory {
	Scanner sc;
	int eventCount;
	int clientCount;
	SortedArrayList<Event> eventList = new SortedArrayList<Event>();
	SortedArrayList<Client> clientlist = new SortedArrayList<Client>();
	File readFile;
	public static final String CRLF = "\r\n";

	/**
	 * while initialize this class,call method read to read data from file "Info_File.txt"
	 *  which is stored in current work path
	 */
	public DataFactory() {
		read();
	}

	public void read() {
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

				clientCount = sc.nextInt();// another to read one line of number
				int readclientCount = clientCount; // replace it in read loop
				sc.nextLine();
				while (sc.hasNextLine() && readclientCount > 0) {
					String[] str = sc.nextLine().split(" ");
					Client current = new Client(str[0], str[1]);
					/*
					 * ArrayList<String> temp=new ArrayList<String>(str.length);
					 * Collections.addAll(temp, str); temp.removeIf(n->n==" ");
					 * str=(String[])temp.toArray();
					 */
					
					// read the info in client,spilt into array,
					//if length<2,means it hasn't buy any ticket
					//else if length=4,buy ticket for one event
					//else if length=6,buy ticket for two events 
					//else if length=8,buy ticket for three events 
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
	 * after input "f" during main menu, store the data into info_File then terminate the program
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

	// public static void main(String[] args) {
	// DataReader dr = new DataReader();
	// dr.read();
	// }

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
	}

	public SortedArrayList<Client> getClientsList() {
		return this.clientlist;
	}

	/**
	 * @param clientFirName
	 * @param clientSurName
	 * @param eventName
	 * @param amount
	 * handle the operation of buying ticket,call method in client and event
	 */
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
			boolean enoughF=eventList.get(eventIndex).buyTicket(amount);
			if (enoughF) {
				clientlist.get(clientIndex).addEvent(eventName, amount);
			}
			else {
				clientlist.get(clientIndex).infoClient(eventName);
			}
		}

		if (!CmatchFlag) {
			System.out.println("Illegal cilent!");
//			System.out.println("press enter to go back menu");
		}
		if (!EmatchFlag) {
			System.out.println("Illegal event!");
//			System.out.println("press enter to go back menu");
		}
	}

	/**
	 * @param clientFirName
	 * @param clientSurName
	 * @param eventName
	 * @param amount
	 * handle the operation of canceling ticket,call method in client and event
	 */
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
