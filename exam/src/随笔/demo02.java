package Ëæ±Ê;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class demo02 {
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		for (int i = 0; i < 5; i++) {
			System.out.print(a + " ");
			if (a < 5) {
				a = a - i;
			} else {
				a = a + 1;
				if (a == 2) {
					break;
				}
			}
		}*/
		for (int i = 0; i < 20; i++) {
			
			random();
		}
	}
	
	
	public static void random() {
		int random=new Random().nextInt(90)+10;
		System.out.println(random);
	}
}
