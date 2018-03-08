package test;

import java.util.Calendar;

import classpackage.Car;
import classpackage.CarFactory;
import classpackage.Company;
import classpackage.DriveLicence;
import classpackage.Name;
import classpackage.Person;

public class UseSmallCarTest {

	public UseSmallCarTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		UseSmallCarTest usct = new UseSmallCarTest();
		usct.testSmallCar();
	}

	private void testSmallCar() {
		// test type
		try {
			final Car c1 = CarFactory.getInstance("small");
			Assertions.assertEquals("small", c1.getType());
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test right drive
		try {
			Company company = new Company();

			Name name = new Name("Peter", "Smith");
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(1974, 3, 22);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.set(1994, 3, 22);
			final Person p = new Person(name, calendar1.getTime());
			final DriveLicence dl = new DriveLicence(p, calendar2.getTime());

			final Car c1 = CarFactory.getInstance("small");
			company.addCar(c1);
			company.issueCar(dl, "small");
			Assertions.assertEquals(c1.driveCar(5), 1);
			Assertions.assertEquals(c1.addFuel(1), 1);
			Assertions.assertEquals(c1.driveCar(30), 2);
			Assertions.assertEquals(company.terminateRental(dl), 2);
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test null param during issue car
		try {
			Company company = new Company();
			Name name = new Name("Peter", "Smith");
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(1974, 3, 22);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.set(1994, 3, 22);
			final Person p = new Person(name, calendar1.getTime());
			final DriveLicence dl = new DriveLicence(p, calendar2.getTime());

			final Car c1 = CarFactory.getInstance("small");
			// c1.addFuel(49);
			company.addCar(c1);
			company.issueCar(dl, "");
			Assertions.assertNotReached();

		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test negative amount during adding fuel
		try {
			Company company = new Company();
			Name name = new Name("Peter", "Smith");
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(1974, 3, 22);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.set(1994, 3, 22);
			final Person p = new Person(name, calendar1.getTime());
			final DriveLicence dl = new DriveLicence(p, calendar2.getTime());

			final Car c1 = CarFactory.getInstance("small");
			company.addCar(c1);
			company.issueCar(dl, "small");
			c1.addFuel(-20);
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test negative amount during driving car
		try {
			Company company = new Company();
			Name name = new Name("Peter", "Smith");
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(1974, 3, 22);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.set(1994, 3, 22);
			final Person p = new Person(name, calendar1.getTime());
			final DriveLicence dl = new DriveLicence(p, calendar2.getTime());

			final Car c1 = CarFactory.getInstance("small");
			// c1.addFuel(49);
			company.addCar(c1);
			company.issueCar(dl, "small");
			c1.driveCar(-20);
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		System.out.println("test use small car success!");
	}
}
