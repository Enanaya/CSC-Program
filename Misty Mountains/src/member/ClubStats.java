package member;

import java.util.ArrayList;
import java.util.Scanner;

import listMethod.Mylist;
import method.Example_G;

import method.method;

public class ClubStats extends method { // main class to call all things

	public static void main(String[] args) {

		Example_G cm_example = new Example_G();
		ArrayList<Climber_Mountain> cm = cm_example.getcm();
		Club club = new Club("Jumping");

		ArrayList<Climber> climbers = cm_example.getC();

		ArrayList<Mountain> mountains = cm_example.getM();

		// int id = 1;

		for (Climber temp : climbers) {
			if (temp.getName() == temp.getName()) {
				temp.create_cm(cm);
			}
		}

		while (true) {

			String gender = null;
			System.out.println();
			climbers = method.distinct(climbers);
			club.setClimbers(climbers);
			club.setCm(climbers);

			System.out.println("please input number to choose");
			System.out.println("1.add a new climber ");
			System.out.println("2.add a mountain to the record for a given climber");
			System.out.println("3.statistics");
			System.out.println("4.exit");

			// System.out.println(in);
			switch (new Scanner(System.in).next()) {

			case "1":
				method.add_climber( gender,  climbers);
				break;
			case "2":
				method.add_CM(cm, climbers, mountains, gender);
				break;
			case "3":
				method.statistics(cm, climbers);
				break;
			case "4":
				System.exit(0);
				break;
			default:
				System.out.println("meanless input,do again!");
				continue;
			}
		}
	}
	
	
	
	
		
	
}
