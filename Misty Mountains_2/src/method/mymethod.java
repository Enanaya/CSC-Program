package method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import member.CM_info;
import member.Climber;
import member.Club;

public class mymethod {

	static ArrayList<Climber> climbers=Example.getClimbers();
	
	public static Map<String, Climber> setCM_info(ArrayList<CM_info> cm_infos) {
		Map<String, Climber> map=new HashMap<String,Climber>();
		Climber climber=new Climber();
		for (CM_info cm_info : cm_infos) {
			String c_name=cm_info.getC_name();
				if (!map.containsKey(c_name)) {
					//先遍历example创建的实例有没有该climber的数据
					for (Climber climber2 : climbers) {
						if (climber2.getC_name()==c_name ) {
							climber=climber2;
							climber.addCm_infos(cm_info);
							map.put(c_name, climber);
						}
					}
				}
				else {
				map.get(c_name).addCm_infos(cm_info);
				}
		}
		return map;
	}
	
	public static void add_climber(String gender,Club club) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("input new climber's name");
		String new_Cname = sc1.nextLine();
		gender=genderChoose(gender, sc1);
		System.out.println("input age");
		int age = sc1.nextInt();
		Climber climber = new Climber(new_Cname,gender,age);
		club.getMap().put(new_Cname, climber);
	}
	
	public 	static void statistic(Club club) {
		Climber temp=club.Max_average();
		System.out.println(temp.getC_name()+ 
				" recorded the highest average mountain height: " +temp.average());
		
		CM_info highest=club.getHighset();
		System.out.println("\nthe highest mountain,"+ highest.getM_name()+",recorded by"+
		highest.getC_name() +" for " +highest.getCurrent_height()+"m");
		pointedHeight(club);
	}
	
	public static void pointedHeight(Club club) {
		ArrayList<CM_info> pointedCM = new ArrayList<CM_info>();
		
		System.out.println("\nplease input pointed height(int) to get list");
		Scanner scanner=new Scanner(System.in);
		int height=scanner.nextInt();
		scanner.nextLine();
		pointedCM=club.pointed_height(height);
		
		System.out.println("records that higher than "+height+" m");
		System.out.println("C_name\tM_name\tHeight");
		for (CM_info cm_info : pointedCM) {
			System.out.println(cm_info.getC_name()+"\t" +cm_info.getM_name()+"\t" +cm_info.getCurrent_height());
		}
	}
	
	
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
	
	
	public static void print_info(Club club) {
		Map<String, Climber> map=club.getMap();
		System.out.println("climber info:");
		for (String key : map.keySet()) {
			System.out.println(key+"\t"+map.get(key).getAge()+"\t"+map.get(key).getGender());
		}
		System.out.println("\nrecord info:");
		for (String key : map.keySet()) {
			for (CM_info cm_info : map.get(key).getCm_infos()) {
				System.out.println(cm_info.getC_name()+"\t"+cm_info.getM_name()+"\t"+cm_info.getCurrent_height());
			}
		}
	}
}
