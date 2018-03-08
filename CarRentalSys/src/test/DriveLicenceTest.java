package test;

import java.util.Calendar;
import java.util.Date;

import classpackage.DriveLicence;
import classpackage.Name;
import classpackage.Person;

public class DriveLicenceTest {
	public DriveLicenceTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DriveLicenceTest dlt = new DriveLicenceTest();
		dlt.testDL();
	}

	private void testDL() {

		// test full param
		Name name = new Name("Peter", "Smith");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1994, 3, 22);
		try {
			final Person p = new Person(name, calendar.getTime());
			final DriveLicence dl = new DriveLicence(p, new Date());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		// test null param
		try {
			final Person p = new Person(name, calendar.getTime());
			final DriveLicence dl = new DriveLicence(p, null);
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}

		try {
			final Person p = new Person(name, calendar.getTime());
			final DriveLicence dl = new DriveLicence(null, new Date());
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}

		System.out.println("test drive licence success!");
	}
}
