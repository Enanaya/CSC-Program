package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Task1.SortedArrayList;

public class DataReader {
	Scanner sc;
	int eventCount;
	int clientCount;
	SortedArrayList<Event> eventList=new SortedArrayList<Event>();
	SortedArrayList<Clients> clientList = new SortedArrayList<Clients>();
	ArrayList<Integer> eventNumList=new ArrayList<Integer>();
	
	public void read() {
		try {
			File file = new File(System.getProperty("user.dir") + "/src/Task2/Input_File");
			if (file.length() == 0) {
				System.out.println("No content in file!");
				return;
			} else {
				sc = new Scanner(new FileReader(file));
				eventCount = Integer.valueOf(sc.nextLine());//read the first line to get the number of events
				while (sc.hasNextLine() && eventCount>0) {
					String Ename=sc.nextLine();
					int Enum=sc.nextInt();
					sc.nextLine();
					eventList.add(new Event(Ename, Enum));
					eventCount--;
				}
				for (Event event : eventList) {
					System.out.println(String.format("%-30s", event.getName())+event.getT_number());
				}
				clientCount=sc.nextInt();//another to read one line of number
				sc.nextLine();
				while (clientCount>0) {
					String[] str=sc.nextLine().split(" ");
					clientList.add(new Clients(str[0], str[1]));
					clientCount--;
				}
				System.out.println();
				for (Clients clients : clientList) {
					System.out.println(clients.getFirstname()+" "+clients.getSurname());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DataReader dr = new DataReader();
		dr.read();
	}
}
