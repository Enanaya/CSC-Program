package threadP;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepDemo {

	public static void main(String[] args) throws InterruptedException {
		Date endtime=new Date(System.currentTimeMillis()+10000);
		long end=endtime.getTime();
		while (true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endtime));
			endtime=new Date(endtime.getTime()-1000);
			if (end-10000>endtime.getTime()) {
				break;
			}
			Thread.sleep(1000);
		}
	}
	
	public void test01() throws InterruptedException {
		int num=10;
		while (true) {
			System.out.println(num);
			Thread.sleep(1000);
			num--;
			if (num<0) {
				break;
			}
		}
	}
}
