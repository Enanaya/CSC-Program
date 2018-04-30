package classpackage;

import java.util.Calendar;
import java.util.Date;

import ·ÏÆú.Assertions;

public class ClientTest {

	private ClientTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final ClientTest ct = new ClientTest();
		ct.testCar();
		ct.testDL();
		ct.testSmallCar();
	}

	private void testCar() {
		/*
		 * final Car c1=CarFactory.getInstance("large"); Car
		 * c2=CarFactory.getInstance("small");
		 * 
		 * System.out.println(c1.getRegistrationNumber());
		 * System.out.println(c2.getRegistrationNumber());
		 */

		// test empty car
		try {
			final Car c1 = CarFactory.getInstance("");
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test wrong car
		try {
			final Car c1 = CarFactory.getInstance("med");
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test status
		try {
			final Car c1 = CarFactory.getInstance("small");
			c1.setRented("RENTED");
			Assertions.assertEquals("RENTED", c1.isRented());
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		try {
			final Car c1 = CarFactory.getInstance("small");
			c1.setRented("NOTRENTED");
			Assertions.assertEquals("NOTRENTED", c1.isRented());
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test empty status
		try {
			final Car c1 = CarFactory.getInstance("small");
			c1.setRented("");
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test wrong status
		try {
			final Car c1 = CarFactory.getInstance("small");
			c1.setRented("wrong");
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		// test fuel 
		try {
			final Car c1 = CarFactory.getInstance("large");
			Assertions.assertEquals(c1.getMaxCapacityOfFuelTank(), c1.getCurrentFuel());
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		System.out.println("success!");
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

		System.out.println("success!");
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
//			c1.addFuel(49);
			company.addCar(c1);
			// System.out.println(company.availableCars("small"));
			company.issueCar(dl, "small");
			// System.out.println(company.getCar(dl).getRegistrationNumber());
			// System.out.println(c1.addFuel(20));
			c1.addFuel(20);
			// System.out.println(c1.driveCar(5));
			c1.driveCar(5);

		} catch (Exception e) {
			System.out.println(e);
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
//			c1.addFuel(49);
			company.addCar(c1);
			company.issueCar(dl, "");

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
//			c1.addFuel(49);
			company.addCar(c1);
			company.issueCar(dl, "small");
			c1.driveCar(-20);
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(IllegalArgumentException.class, t);
		}

		System.out.println("success!");
	}
}
