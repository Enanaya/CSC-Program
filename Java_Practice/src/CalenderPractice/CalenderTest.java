package CalenderPractice;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

//ģ��������δ���
public class CalenderTest {

	public static void main(String[] args) throws IOException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Calendar c = new GregorianCalendar();
			c.setTime(format.parse("2030-2-10"));// ���ַ���������date
			c.set(Calendar.DATE, 1); // �趨����
			// System.out.print("�������·� ");
			// int month=System.in.read();
			// c.set(Calendar.MONTH, month-1);
			int Max_day = c.getActualMaximum(Calendar.DATE);

			// System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println("�·�\t" + (c.get(Calendar.MONTH) + 1));
			System.out.println("������ " + c.getActualMaximum(Calendar.DATE));
			// System.out.println(c.getTime());
			// System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			// ��ȡ�·ݵ�һ�������ڼ������з�����ȡ������ʱ����1�������һ��Ϊ��ȷ
			int dayforweek = c.get(Calendar.DAY_OF_WEEK);
			if (dayforweek == 1) {
				dayforweek = 7;
			} else {
				dayforweek--;
			}

			int j = dayforweek;
			for (int i = 1; i <= Max_day; i++) {
				if (i <= dayforweek) {
					System.out.print(" \t");
				} else {
					for (i = 1; i <= Max_day; i++) {
						System.out.print(i + "\t");
						j++;
						if (j % 7 == 0) {
							System.out.println();
						}
					}
				}
			}

		} catch (

		ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
