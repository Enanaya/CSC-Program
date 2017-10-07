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
			c.setTime(format.parse("2030-5-10") );//���ַ���������date
			c.set(Calendar.DATE, 1);		//�趨����
			
			System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println(c.get(Calendar.DATE));
			System.out.println(c.getActualMaximum(Calendar.MONTH));
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
