package CalenderPractice;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

//模拟日历，未完成
public class CalenderTest {

	public static void main(String[] args) throws IOException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Calendar c = new GregorianCalendar();
			c.setTime(format.parse("2030-2-10"));// 将字符串解析成date
			c.set(Calendar.DATE, 1); // 设定日期
			// System.out.print("请输入月份 ");
			// int month=System.in.read();
			// c.set(Calendar.MONTH, month-1);
			int Max_day = c.getActualMaximum(Calendar.DATE);

			// System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println("月份\t" + (c.get(Calendar.MONTH) + 1));
			System.out.println("总天数 " + c.getActualMaximum(Calendar.DATE));
			// System.out.println(c.getTime());
			// System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			// 获取月份第一天是星期几，其中方法获取星期天时返回1，其余减一即为正确
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
