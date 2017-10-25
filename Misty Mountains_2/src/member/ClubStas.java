package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import method.mymethod;

public class ClubStas {

	public static void main(String[] args) {

		Club club = new Club();
		Map<String, Climber> map = club.getMap();

		while (true) {
			String gender = null;
			System.out.println();

			System.out.println("please input number to choose");
			System.out.println("1.add a new climber ");
			System.out.println("2.add a  record for a given climber");
			System.out.println("3.statistics");
			System.out.println("4.print info");
			System.out.println("5.exit");

			switch (new Scanner(System.in).next()) {
			case "1":
				mymethod.add_climber(gender, club);
				break;
			case "2":
				mymethod.addCM(club);
				break;
			case "3":
				mymethod.statistic(club);
				break;
			case "4":
				mymethod.print_info(club);
				break;
			case "5":
				System.exit(0);
				break;
			default:
				System.out.println("meanless input,do again!");
				continue;
			}
		}
	}
}
