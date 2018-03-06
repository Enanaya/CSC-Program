package classpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class CarFactory implements Car {

	/**
	 * unique identification of car
	 */
	private String reg_number;

	/**
	 * Large car type.
	 */
	public static final String LARGE_CAR = "large";
	/**
	 * Samll car type.
	 */
	public static final String SMALL_CAR = "small";

	private int currentFuel;

	/**
	 * status of car:1.RENTED;2.NOTRENTED
	 */
	private String status;

	private static final String RENTED = "isrented";

	private static final String NOTRENTED = "notrented";

	private final int CapacityOfFuel;

	private static final Map<String, Car> cars = new HashMap<String, Car>();

	protected CarFactory(String reg_number, int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		this.reg_number = reg_number;
		this.CapacityOfFuel = CapacityOfFuel;
	}

	public static Car getInstance(String carType) {
		String reg=regNum_generate();
		Car car = cars.get(reg);
		if (car != null) {
			return car;
		}
		if (carType.equals(LARGE_CAR)) {
			car = new LargeCar(reg, 60);
		} else if (carType.equals(SMALL_CAR)) {
			car = new SmallCar(reg, 49);
		}
		cars.put(reg, car);
		return car;
	}

	private static String regNum_generate() {
		String res = "";
		res+=String.valueOf(new Random().nextInt(26));
		res+=new Random().nextInt(8999)+1000;
		return res;
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		if (status == RENTED) {
			this.status = RENTED;
		} else if (status == NOTRENTED) {
			this.status = NOTRENTED;
		} else {
			// ´¦ÀíÒì³£
		}
	}

	@Override
	public String getRegistrationNumber() {
		// TODO Auto-generated method stub
		return this.reg_number;
	}

	@Override
	public int getMaxCapacityOfFuelTank() {
		// TODO Auto-generated method stub
		return this.CapacityOfFuel;
	}

	@Override
	public int getCurrentFuel() {
		// TODO Auto-generated method stub
		return this.currentFuel;
	}

	@Override
	public boolean isFullFuel() {
		// TODO Auto-generated method stub
		return currentFuel == CapacityOfFuel;
	}

	@Override
	public boolean isRented() {
		// TODO Auto-generated method stub
		return status == RENTED;
	}

	@Override
	public int addFuel(int amount) {
		// TODO Auto-generated method stub
		if (amount > CapacityOfFuel) {
			int _amount = CapacityOfFuel - currentFuel;
			currentFuel = CapacityOfFuel;
			return _amount;
		} else {
			currentFuel += amount;
			return amount;
		}
	}

}
