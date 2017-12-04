package Task2;

import java.util.Scanner;

public class Main_Menu {
	public static void main(String[] args) {
		DataFactory df = new DataFactory();
		Scanner menuSc;
		while (true) {
			menuSc = new Scanner(System.in);
			System.out.println("f - to finish running the program");
			System.out.println("e - to display on the screen the information about all the events");
			System.out.println("c - to display on the screen the information about all the clients");
			System.out
					.println("b - to update the stored data when tickets are bought by one of the registered clients");
			System.out.println("r - to update the stored data when a registered client cancels/returns tickets");
			switch (menuSc.nextLine()) {
			case "f":
				df.write();
				System.exit(0);
				break;
			case "e":
				df.printEvent();
				System.out.println("\npress enter to go back menu");
				menuSc.nextLine();
				break;
			case "c":
				df.printClient();
				System.out.println("\npress enter to go back menu");
				menuSc.nextLine();
				break;
			case "b":
				Scanner bsc = new Scanner(System.in);
				System.out.println("input surname");
				String sur = bsc.nextLine();
				System.out.println("input firstname");
				String fir = bsc.nextLine();
				System.out.println("input event");
				String eve = bsc.nextLine();
				System.out.println("input how much ticket to buy");
				int tic = bsc.nextInt();
				bsc.nextLine();
				df.buyTicket(fir, sur, eve, tic);
				System.out.println("\npress enter to go back menu");
				bsc.nextLine();
				break;
			case "r":
				Scanner rsc = new Scanner(System.in);
				System.out.println("input surname");
				String sur1 = rsc.nextLine();
				System.out.println("input firstname");
				String fir1 = rsc.nextLine();
				System.out.println("input event");
				String eve1 = rsc.nextLine();
				System.out.println("input how much ticket to cancle");
				int tic1 = rsc.nextInt();
				rsc.nextLine();
				df.cancelTicket(fir1, sur1, eve1, tic1);
				System.out.println("\npress enter to go back menu");
				rsc.nextLine();
				break;
			default:
				break;
			}
		}
	}
}
