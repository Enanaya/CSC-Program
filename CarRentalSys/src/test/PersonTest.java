package test;

import java.util.Calendar;
import java.util.Date;

import classpackage.Name;
import classpackage.Person;
import test.Assertions;

public class PersonTest {
	private PersonTest() {
	}

	public static void main(String[] args) {
		final PersonTest tp = new PersonTest();

		tp.testPerson();

		tp.testGetAge();

		tp.testGetName();

		tp.testEquals();
	}

	Name name = new Name("Peter", "Smith");
	Calendar calendar1 = Calendar.getInstance();

	// testing the Person constructor
	private void testPerson() {
		calendar1.set(1974, 3, 22);
		// test normal case

		final Person p = new Person(name, calendar1.getTime());

		Assertions.assertEquals(name, p.getName());
		Assertions.assertEquals(calendar1.getTime(), p.getBirthday());

		// test null name
		try {
			final Person nullName = new Person(null, calendar1.getTime());
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}

		// test empty name
		try {
			final Person emptyName = new Person(null, calendar1.getTime());
			Assertions.assertNotReached();
		} catch (Throwable t) {
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}

		System.out.println("testPerson success");
	}

	private void testGetAge() {
		final Person p = new Person(name, calendar1.getTime());

		Assertions.assertEquals(calendar1.getTime(), p.getBirthday());

		System.out.println("testGetAge success");
	}

	private void testGetName() {
		final Person p = new Person(name, calendar1.getTime());

		Assertions.assertEquals(name, p.getName());

		System.out.println("testGetName success");
	}

	private void testEquals() {
		final Person p = new Person(name, calendar1.getTime());

		Assertions.assertTrue(p.equals(p));

		Assertions.assertFalse(p.equals(null));

		Assertions.assertFalse(p.equals(new Person(name, new Date())));

		Assertions.assertFalse(p.equals(new Person(new Name("Pesaf", "Smith"), calendar1.getTime())));

		Assertions.assertFalse(p.equals(new Person(new Name("Pesaf", "Smith"), new Date())));

		System.out.println("testEquals success");
	}
}
