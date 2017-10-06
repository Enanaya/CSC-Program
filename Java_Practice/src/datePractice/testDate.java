package datePractice;

import java.util.Date;

public class testDate {
	public static void main(String[] args) {
		Date d = new Date();
		//Date方法里的tolocaldate已被弃用
		long d2=System.currentTimeMillis();
	    System.out.println(d);
	}
}
