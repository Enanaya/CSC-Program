package member;

import java.io.IOException;

public class ClubStats { // main class to call all things

	public static void main(String[] args) {
		
		System.out.println("please input number to choose");
		System.out.println("1.add a new climber ");
		System.out.println("2.add a mountain to the record for a given climber");
		System.out.println("3.statistics");
		System.out.println("4.exit");

		try {
			while (true) {
				switch (System.in.read()) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					System.out.println("meanless input,input again!");
					continue;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
