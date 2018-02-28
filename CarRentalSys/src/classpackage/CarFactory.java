package classpackage;

import java.util.HashMap;
import java.util.Map;

public abstract class CarFactory implements Car{
	
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

	private final int CapacityOfFuel;
	
	private static final String RENTED="isrented";

	private static final String NOTRENTED="notrented";
	
	private static final Map<String, Car> cars = new HashMap<String, Car>();
	
	protected CarFactory(String reg_number,int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		this.reg_number=reg_number;
		this.CapacityOfFuel=CapacityOfFuel;
	}
	
	public static Car getInstance(String carType,String reg_number) {
		Car car=cars.get(reg_number);
		if (car!=null) {
			return car;
		}
		 if (carType.equals(LARGE_CAR)) {
			car= new LargeCar(reg_number,60);
		}
		 else if (carType.equals(SMALL_CAR)) {
			car=new SmallCar(reg_number,49);
		}
		 cars.put(reg_number, car);
		 return car;
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
		return currentFuel==CapacityOfFuel;
	}

	@Override
	public boolean isRented() {
		// TODO Auto-generated method stub
		return status==RENTED;
	}

	@Override
	public int addFuel(int amount) {
		// TODO Auto-generated method stub
		if (amount>CapacityOfFuel) {
			int _amount=CapacityOfFuel-currentFuel;
			currentFuel=CapacityOfFuel;
			return _amount;
		}else {
			currentFuel+=amount;
			return amount;
		}
	}

	

}
