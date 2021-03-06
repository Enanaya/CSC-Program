package method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import member.CM_info;
import member.Climber;
import member.Club;

/**
 * store method to get/set info
 *
 */
public class mymethod {

	static ArrayList<Climber> climbers=Example.getClimbers();
	
	/**
	 * @param cm_infos get from example
	 * @return use CM_infos from to initialize data
	 */
	public static Map<String, Climber> setCM_info(ArrayList<CM_info> cm_infos) {
		Map<String, Climber> map=new HashMap<String,Climber>();
		Climber climber=new Climber();
		for (CM_info cm_info : cm_infos) {
			String c_name=cm_info.getC_name();
				if (!map.containsKey(c_name)) {
					//foreach example to check whether it contains data of climber whose name is c_name
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
	
	
	/**
	 * @param club
	 * send club then input CM_info to add into info where match with Climber's name
	 */
	public static void addCM(Club club) {
		Scanner sc=new Scanner(System.in);
		System.out.println("input climber's name:");
		String C_name=sc.nextLine();
		System.out.println("input mountain's name");	
		String M_name=sc.nextLine();
		System.out.println("input height");
		int height=sc.nextInt();
		sc.nextLine();
		Map< String, Climber> map=club.getMap();
		CM_info cm_info=new CM_info(C_name, M_name, height);
		boolean flag=true;
		for (String key : map.keySet()) {
			if (key.equals(C_name)) {
				map.get(key).getCm_infos().add(cm_info);
				break;
			}
			flag=false;
		}
		if (flag==false) {
			System.out.println("can not find this climber,plz complete information");
			String gender=null;
			genderChoose(gender, sc);
			System.out.println("input age:");
			int age=sc.nextInt();
			Climber climber = new Climber(C_name,gender,age);
			club.getMap().put(C_name, climber);
			for (String key : map.keySet()) {
				if (key==C_name) {
					map.get(key).getCm_infos().add(cm_info);
					break;
				}
			}
		}
		
	}
	
	
	/**
	 * @param gender choose gender with genderchoose method
	 * @param club
	 * use data to add climber into club
	 */
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
	
	/**
	 * @param club
	 * show data including highest average height and pointed height using  pointedHeight method
	 */
	public 	static void statistic(Club club) {
		Climber temp=club.Max_average();
		System.out.println(temp.getC_name()+ 
				" recorded the highest average mountain height: " +temp.average());
		
		CM_info highest=club.getHighset();
		System.out.println("\nthe highest mountain,"+ highest.getM_name()+",recorded by"+
		highest.getC_name() +" for " +highest.getCurrent_height()+"m");
		pointedHeight(club);
	}
	
	/**
	 * @param club
	 * input height to return list which CM_info's current height is higher than input height
	 */
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
	
	
	/**
	 * @param gender
	 * @param sc1
	 * @return gender:female or male
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
	 * @param club
	 * show data including CM_infos and Climbers
	 */
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
