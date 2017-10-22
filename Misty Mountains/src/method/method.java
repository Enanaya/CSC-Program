package method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import listMethod.Mylist;
import member.Climber;
import member.Climber_Mountain;
import member.Mountain;

public class method {

	/**
	 * @param climbers
	 * print all user
	 */
	public static void printUser(ArrayList<Climber> climbers) {
		System.out.println("current cilmbers:");
		System.out.println("name\tgender\tage");
		for (Climber climber : climbers) {
			System.out.println(climber.getName()+"\t"+climber.getGender()+"\t"+climber.getAge());
		}
	}

	/**
	 * @param cm
	 * print all cm_info
	 */
	public static void printCM(ArrayList<Climber_Mountain> cm) {
		System.out.println("current CM_info:");
		System.out.println("name\tmountain\theight");
		for (Climber_Mountain temp : cm) {
			System.out.println(temp.getClimber_name()+"\t"+temp.getMountain_name()
			+"\t"+temp.getCurrent_height());
		}
	}
	
	/**
	 * @param id
	 * @param Climber_name
	 * @param Mountain_name
	 * @param height
	 * @return add cm_info with param
	 */
	public static Climber_Mountain addRecord(int id, String Climber_name, 
			String Mountain_name, int height) {
		return new Climber_Mountain(id, Climber_name, Mountain_name, height);
	}
	
	/**
	 * @param mylist
	 * @return list after delete repeat elements in mylist
	 */
	public  static ArrayList distinct(ArrayList mylist) {
		Set set = new HashSet();
		ArrayList newList = new ArrayList();
		for (Iterator iter = mylist.iterator(); iter.hasNext();) {
			Object element =  iter.next();
			if (set.add(element))
				newList.add(element);
		}
		mylist.clear();
		mylist.addAll(newList);
		return mylist;
	}
	
	/**
	 * @param gender
	 * @param climbers
	 * add climber if can not find name while add cm_info
	 */
	public static void add_climber(String gender,ArrayList<Climber> climbers) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("input new climber's name");
		String new_Cname = sc1.nextLine();
		gender=genderChoose(gender, sc1);
		System.out.println("input age");
		int age = sc1.nextInt();
		// sc1.close();

		Climber climber = new Climber(new_Cname, age, gender);
		climbers.add(climber);
//		break;
		printUser(climbers);
	}
	
	
	/**
	 * @param gender
	 * @param sc1
	 * @return gender 1.femal 2.male
	 */
	private static String genderChoose(String gender,Scanner sc1) {
		while(gender==null) {
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
			}
		}
		return gender;
	}
	
	/**
	 * @param cm
	 * @param climbers
	 * @param mountains
	 * @param gender
	 * add cm_info
	 */
	public static void add_CM(ArrayList<Climber_Mountain> cm, ArrayList<Climber> climbers,
			ArrayList<Mountain> mountains,String gender) {
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
		
		int count=0;
		for (Climber temp : climbers) {
			if (temp.getName().equals(cm.get(cm.size() - 1).getClimber_name())) {
//				System.out.println("right");
				temp.update_cm(cm.get(cm.size() - 1));
				break;
			}
			count++;
		}
		if (count==climbers.size()) {
			System.out.println("can't not find this member,please upplementary individual belief\n");
			Scanner sc4=new Scanner(System.in);
			gender=genderChoose(gender, sc4);
			
			System.out.println("input age");
			int new_age=sc4.nextInt();
			
			Climber new_C = new Climber(C_name,new_age,gender);
			Mountain new_M=new Mountain(M_name, height);
			mountains.add(new_M);
			climbers.add(new_C);
			for (Climber temp : climbers) {
				if (temp.getName().equals(cm.get(cm.size() - 1).getClimber_name())) {
					//System.out.println("right");
					temp.update_cm(cm.get(cm.size() - 1));
					break;
				}
			}
			printUser(climbers);
		}
		System.out.println();
		printCM(cm);
		// System.out.println(cm.size());
		
	}

	public static void statistics(ArrayList<Climber_Mountain> cm, ArrayList<Climber> climbers) {
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
	}
}
