package test;

import classpackage.Car;
import classpackage.CarFactory;

public class CarTest {

	private CarTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final CarTest ct = new CarTest();
		ct.testCar();
	}

	private void testCar() {

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

		System.out.println("test car success!");
	}

}
