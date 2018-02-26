package classpackage;

public class LargeCar implements Car{
	/**
	 * unique identification of car
	 */
	private String reg_number;
	
	/**
	 * sever as a fiel to distinguish with large car while system try to search available cars or else
	 */
	private String CarType="LargeCar";
	
	/**
	 * large car's fuel capacity is 60L 
	 */
	private int CapacityOfFuel=60;
	
	private int currentFuel;
	
	/**
	 * status of car:1.RENTED;2.NOTRENTED
	 */
	private String status;
	
	private static final String RENTED="isrented";
	
	private static final String NOTRENTED="notrented";
	
	
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

	@Override
	public int driveCar(int km) {
		// TODO Auto-generated method stub
		return 0;
	}
}
