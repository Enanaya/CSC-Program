package member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import method.Example_G;

import method.method;

public class ClubStats extends method { // main class to call all things

	public static void main(String[] args) {

		Example_G cm_example = new Example_G();
		ArrayList<Climber_Mountain> cm = cm_example.getcm();
		int id = 1;

		while (true) {
			System.out.println("please input number to choose");
			System.out.println("1.add a new climber ");
			System.out.println("2.add a mountain to the record for a given climber");
			System.out.println("3.statistics");
			System.out.println("4.exit");

			//				System.out.println(in);
			switch (new Scanner(System.in).next()) {
			case "1":
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入登山者姓名：");
				String C_name = sc.nextLine();
				System.out.println("请输入山的名字：");
				String M_name = sc.nextLine();
				System.out.println("请输入高度：");
				int height = sc.nextInt();
				if (cm.isEmpty()) {
					cm.add(addRecord(1, C_name, M_name, height));
				} else {
					cm.add(addRecord(id++, C_name, M_name, height));
				}
				System.out.println(cm.size());
				break;
			case "2":

				break;
			case "3":
				break;
			case "4":
				break;
			default:
				System.out.println("meanless input,input again!");
				continue;
			}
		}
	}
}
