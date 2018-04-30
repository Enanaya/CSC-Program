package classpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * a class as object factor to create car
 * @author Z.Liang
 *
 */
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
	private String status=NOTRENTED;

	private static final String RENTED = "isrented";

	private static final String NOTRENTED = "notrented";

	private final int CapacityOfFuel;

	private static final Map<String, Car> cars = new HashMap<String, Car>();

	protected CarFactory(String reg_number, int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		this.reg_number = reg_number;
		this.CapacityOfFuel = CapacityOfFuel;
		currentFuel=CapacityOfFuel;
	}

	/** method to create new car or if the amount of car is full,return exist car
	 * @param carType  the type of car to create
	 * @return new car with unique registration number
	 */
	public static Car getInstance(String carType) {
		String reg=regNum_generate();
		Car car = cars.get(reg);
		if (car != null) {
			return car;
		}
		if (carType.equals(LARGE_CAR)) {
			int count=0;
			for (Car car2 : cars.values()) {
				if (car2.getType().equals(LARGE_CAR)) {
					count++;
				}
			}
			if (count>=20) {
				return null;
			}
			car = new LargeCar(reg, 60);
		} else if (carType.equals(SMALL_CAR)) {
			int count=0;
			for (Car car2 : cars.values()) {
				if (car2.getType().equals(LARGE_CAR)) {
					count++;
				}
			}
			if (count>=30) {
				return null;
			}
			car = new SmallCar(reg, 49);
		}else {
			throw new IllegalArgumentException(
                    "invalid car type: " + carType);

		}
		cars.put(reg, car);
		return car;
	}

	private static String regNum_generate() {
		String res = "";
		Random random = new Random(); 
		int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
		res+=(char)(random.nextInt(26)+temp);
		res+=random.nextInt(8999)+1000;
		return res;
	}

	@Override
	public void setRented(String status) {
		// TODO Auto-generated method stub
		if (status == RENTED) {
			this.status = RENTED;
		} else if (status == NOTRENTED) {
			this.status = NOTRENTED;
		} else {
			throw new IllegalArgumentException(
                    "invalid status type: " + status);
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
		if (amount<0) {
			throw  new IllegalArgumentException("negative amount");
		}
		if (this.isRented() || this.currentFuel==this.CapacityOfFuel) {
			return 0;
		}
		int rest_amount = CapacityOfFuel - currentFuel;
		if (amount > rest_amount) {
			currentFuel = CapacityOfFuel;
			return rest_amount;
		} else {
			currentFuel += amount;
			return amount;
		}
	}

}
