package ·ÏÆú;

import classpackage.Car;

public abstract  class abstractCar implements Car{
	/**
	 * unique identification of car
	 */
	private String reg_number;
	
	private String CarType="LargeCar";
	
	private int CapacityOfFuel=60;
	
	private int currentFuel;
	
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
