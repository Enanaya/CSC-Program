package classpackage;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

public class Company {
	private Map<String, DrivingLicence> record;
	private ArrayList<Car> cars;
	
	/** This method returns the number of cars of the specified type that are available to rent.
	 * @param carType type of car
	 * @return number of cars of the specified type that are available to rent
	 */
	public int availableCars(Car carType) {
		int amount;
		
		return 0;
	}
	
	
	/** This method returns a collection of all the cars currently rented out (if any)
	 * @return list of all the cars currently rented out
	 */
	public ArrayList<Car> getRentedCars() {
		return null;
	}
	
	/** Given a person's driving licence, this method returns the car they are currently renting
	 * @param drivingLicence person's driving licence to find record
	 * @return car the person are currently renting(if any)
	 */
	public Car getCar(String drivingLicence) {
		return null;
	}
	
	/** Given a person's driving licence and a specification of the type of car required (small
	 * or large), this method determines whether the person is eligible to rent a car of the
	 * specified type and, if there is a car available, issues a car of the specified type.
	 * @param drivingLicence person's driving licence
	 * @param typeOfCar  typeOfCar to issue
	 */
	public void issueCar(String drivingLicence, String typeOfCar) {
		
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
