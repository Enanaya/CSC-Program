package CalenderPractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalenderTest {
	public static void main(String[] args) {
		Calendar c=new GregorianCalendar();
		DateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		try {
			c.setTime(format.parse("2030-5-10") );//将字符串解析成date
			c.set(Calendar.DATE, 1);		//设定日期
			
			System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println(c.get(Calendar.DATE));
			System.out.println(c.getActualMaximum(Calendar.MONTH));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
