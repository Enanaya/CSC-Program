package classpackage;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

public class Company {
	private Map<DrivingLicence, Car> record;
	
	/**
	 * store the info of all cars(70 at all) 
	 */
	private ArrayList<Car> cars;
	
	/** This method returns the number of cars of the specified type that are available to rent.
	 * @param carType type of car
	 * @return number of cars of the specified type that are available to rent
	 */
	public int availableCars(Car carType) {
		int Small_amount=0;
		int Large_amount = 0;
		for (Car car : cars) {
			if (car instanceof LargeCar) {
				Large_amount++;
			}
			else if (car instanceof SmallCar) {
				Small_amount++;
			}
		}
		
		if (carType.equals("large")) {
			return Large_amount;
		}
		else if(carType.equals("small")){
			return Small_amount;
		}
		else {
			//此处应丢出一个异常
			return 0;
		}
	}
	
	
	/** This method returns a collection of all the cars currently rented out (if any)
	 * @return list of all the cars currently rented out
	 */
	public ArrayList<Car> getRentedCars() {
		ArrayList<Car> rentedcars = new ArrayList<Car>();
		cars.forEach(n->{if (n.isRented()) {
			rentedcars.add(n);
		}});
		return rentedcars;
	}
	
	/** Given a person's driving licence, this method returns the car they are currently renting
	 * @param drivingLicence person's driving licence to find record
	 * @return car the person are currently renting(if any)
	 */
	public Car getCar(DrivingLicence drivingLicence) {
		if (record.containsKey(drivingLicence)) {
			return record.get(drivingLicence);
		}
		return null;
	}
	
	/** Given a person's driving licence and a specification of the type of car required (small
	 * or large), this method determines whether the person is eligible to rent a car of the
	 * specified type and, if there is a car available, issues a car of the specified type.
	 * @param drivingLicence person's driving licence
	 * @param typeOfCar  typeOfCar to issue
	 */
	public void issueCar(DrivingLicence drivingLicence, String typeOfCar) {
		
	}
	
	/** This method terminates the rental contract associated with the given driving licence. In
	 * effect, the driver is returning the car. The car is then available for rent by someone else.
	 * The method removes the record of the rental from the company's records (disassociating  the 
	 * car from the licence) and returns the amount of fuel in Litres required to fill the car's tank.
	 * @param drivingLicence person's driving licence
	 * @return the amount of fuel in Litres required to fill the car's tank
	 */
	public boolean terminateRental(String drivingLicence) {
		return true;
	}
}
