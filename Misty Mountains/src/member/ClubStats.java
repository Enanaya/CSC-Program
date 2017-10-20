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

		String gender = null;
		// int id = 1;

		for (Climber temp : climbers) {
			if (temp.getName() == temp.getName()) {
				temp.create_cm(cm);
			}
		}

		while (true) {

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
				Scanner sc1 = new Scanner(System.in);
				System.out.println("input new climber's name");
				String new_Cname = sc1.nextLine();
				System.out.println("choose gender: 1.Female 2.Male ");
				String gender_choose = sc1.nextLine();
				// System.out.println(gender_choose);
				switch (gender_choose) {
				case "1":
					gender = "Female";
					break;
				case "2":
					gender = "Male";
					break;
				default:
					System.out.println("meanless input,do again!");
					continue;
				}
				System.out.println("input age");
				int age = sc1.nextInt();
				// sc1.close();

				Climber climber = new Climber(new_Cname, age, gender);
				climbers.add(climber);
				break;

			case "2":
				Scanner sc2 = new Scanner(System.in);
				System.out.println("input climber's name");
				String C_name = sc2.nextLine();
				System.out.println("input mountain's name");
				String M_name = sc2.nextLine();
				System.out.println("input height");
				int height = sc2.nextInt();
				// sc2.close();
				if (cm.isEmpty()) {
					cm.add(addRecord(1, C_name, M_name, height));
				} else {
					cm.add(addRecord(cm.size() + 1, C_name, M_name, height));
				}
				// for (Climber temp : climbers) {
				// if (temp.getName()==C_name) {
				// temp.update_cm(cm);
				//
				// }
				// }
				for (Climber temp : climbers) {
					if (temp.getName().equals(cm.get(cm.size() - 1).getClimber_name())) {
						System.out.println("right");
						temp.update_cm(cm.get(cm.size() - 1));
					}
				}
				// System.out.println(cm.size());
				break;

			case "3":
				/// climber who has max average mountain height
				Climber Top_C = new Climber();
				int max_C = 0;
				for (Climber temp : climbers) {
					if (temp.average() > max_C) {
						Top_C = temp;
						max_C = temp.average();
					}
				}
				System.out.println("Statistics:");
				System.out.println(
						Top_C.getName() + " recorded the highest average mountain height: " + Top_C.average() + "m");

				/// the highest mountain recorded by a member
				Climber_Mountain Top_CM = new Climber_Mountain();
				int max_CM = 0;
				for (Climber_Mountain temp : cm) {
					if (temp.getCurrent_height() > max_CM) {
						max_CM = temp.getCurrent_height();
						Top_CM = temp;
					}
				}
				System.out.println("the highest mountain record: " + Top_CM.getMountain_name() + "m---"
						+ Top_CM.getCurrent_height() + " by " + Top_CM.getClimber_name());
				System.out.println();

				/// get the pointed height

				
				Scanner sc3 = new Scanner(System.in);
				while (true) {
					System.out.println("please input number to choose");
					System.out.println("1. input pointed hieght to get info \n2. exit");
					switch (new Scanner(System.in).next()) {
					case "1":
						System.out.print("input height:  ");
						int pointed_height = sc3.nextInt();
						// int pointed_height=string.;
						System.out.println("C_name \t M_name \tHeight");

						for (Climber temp : climbers) {
							for (Climber_Mountain temp1 : temp.pointed_mountains(pointed_height)) {
								System.out.println(temp1.getClimber_name() + "\t  " 
							    + temp1.getMountain_name() + "\t\t"+ temp1.getCurrent_height());
							}
						}
						sc3.nextLine();
						sc3.nextLine();
						continue;
					case "2":
						break;
					default:
						System.out.println("meanless input,do again!");
						continue;
					}
					break;
				}
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
