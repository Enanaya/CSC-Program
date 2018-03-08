package test;

import java.util.Calendar;

import org.junit.Test;

import classpackage.Car;
import classpackage.CarFactory;
import classpackage.Company;
import classpackage.DriveLicence;
import classpackage.LicenceNum;
import classpackage.Name;
import classpackage.Person;

public class ExceptionalTest {
	public ExceptionalTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ExceptionalTest et = new ExceptionalTest();
		et.WrongDLTest1();
	}

	@Test
	public void WrongDLTest1() {
		Name name = new Name("Peter", "Smith");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(1974, 3, 22);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(1994, 3, 22);
		LicenceNum ln = new LicenceNum(new Person(name, calendar1.getTime()), calendar2.getTime());
	}

	@Test
	public void negativeDriveTest() {
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
		c1.driveCar(-20);
	}

	@Test
	public void negativeAddFuelTest() {
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
		c1.driveCar(20);
		c1.addFuel(-20);
	}
}
