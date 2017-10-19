package member;

import java.util.ArrayList;
import java.util.Scanner;

import method.Example_G;

import method.method;

public class ClubStats extends method { // main class to call all things

	public static void main(String[] args) {

		Example_G cm_example = new Example_G();
		ArrayList<Climber_Mountain> cm = cm_example.getcm();
		ArrayList<Climber> climbers = cm_example.getC();
		String gender=null;

		int id = 1;

		while (true) {

			System.out.println("please input number to choose");
			System.out.println("1.add a new climber ");
			System.out.println("2.add a mountain to the record for a given climber");
			System.out.println("3.statistics");
			System.out.println("4.exit");

			// System.out.println(in);
			switch (new Scanner(System.in).next()) {
			case "2":
				Scanner sc2 = new Scanner(System.in);
				System.out.println("input climber's name");
				String C_name = sc2.nextLine();
				System.out.println("input mountain's name");
				String M_name = sc2.nextLine();
				System.out.println("input height");
				int height = sc2.nextInt();
				sc2.close();
				if (cm.isEmpty()) {
					cm.add(addRecord(1, C_name, M_name, height));
				} else {
					cm.add(addRecord(id++, C_name, M_name, height));
				}
				for (Climber climber : climbers) {
					if (climber.getName()==C_name) {
						climber.update_cm(cm);
					}
				}
				
				// System.out.println(cm.size());
				break;
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
				int age=sc1.nextInt();
				sc1.close();
				
				Climber climber=new Climber(new_Cname, age, gender);
				climbers.add(climber);
				break;
				
			case "3":
				System.out.println("climber who recorded the highest average mountain height");
				
				break;
			case "4": System.exit(0);
				break;
			default:
				System.out.println("meanless input,do again!");
				continue;
			}
		}
	}
}
