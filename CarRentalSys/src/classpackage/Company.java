package classpackage;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Company {
	private static Map<DriveLicence, Car> record=new HashMap<DriveLicence, Car>();
	
	/**
	 * store the info of all cars(50 at all) 
	 */
	private static ArrayList<Car> cars=new ArrayList<Car>();
	
	private int sc_amount;
	private int lc_amount;
	
	public Company() {
		// TODO Auto-generated constructor stub
		sc_amount=0;
		lc_amount=0;
	}
	
	public  void addCar(Car c) {
		cars.add(c);
		if (c instanceof SmallCar) {
			sc_amount++;
		}
		if (c instanceof LargeCar) {
			lc_amount++;
		}
	}
	
	
	/** This method returns the number of cars of the specified type that are available to rent.
	 * @param carType type of car
	 * @return number of cars of the specified type that are available to rent
	 */
	public int availableCars(String carType) {
		
		if (carType.equals("small")) {
			return sc_amount;
		}
		else if(carType.equals("large")){
			return lc_amount;
		}
		else {
			throw new IllegalArgumentException(
                    "invalid car type: " + carType);
		}
	}
	
	
	/** This method returns a collection of all the cars currently rented out (if any)
	 * @return list of all the cars currently rented out
	 */
	public ArrayList<Car> getRentedCars() {
		/*ArrayList<Car> rentedcars = new ArrayList<Car>();
		cars.forEach(n->{if (n.isRented()) {
			rentedcars.add(n);
		}});*/
		return  new ArrayList<Car>(record.values());
//		return rentedcars;
	}
	
	/** Given a person's driving licence, this method returns the car they are currently renting
	 * @param drivingLicence person's driving licence to find record
	 * @return car the person are currently renting(if any)
	 */
	public Car getCar(DriveLicence drivingLicence) {
		if (record.containsKey(drivingLicence)) {
			return record.get(drivingLicence);
		}else {
			throw new IllegalArgumentException(
                    "no drivelicence record: " + drivingLicence);
		}
	}
	
	/** Given a person's driving licence and a specification of the type of car required (small
	 * or large), this method determines whether the person is eligible to rent a car of the
	 * specified type and, if there is a car available, issues a car of the specified type.
	 * @param drivingLicence person's driving licence
	 * @param typeOfCar  typeOfCar to issue
	 */
	public void issueCar(DriveLicence drivingLicence, String carType) {
		/*LocalDate today=LocalDate.now();
		Instant instant = drivingLicence.getBirthday().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        
        LocalDate birthday = instant.atZone(zoneId).toLocalDate();
		Period p=Period.between(birthday,today);
		int age=p.getYears(); //age of licence holder
*/		
		
		if (record.containsKey(drivingLicence)) {
			System.out.println(); //one person can only rent one car
			return ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();
		int age = Integer.parseInt(sdf.format(date))
				- Integer.parseInt(sdf.format(drivingLicence.getBirthday()));
		int LicTime = Integer.parseInt(sdf.format(date))
				- Integer.parseInt(sdf.format(drivingLicence.getIssueDate()));
		
		if (drivingLicence.isFull()) {
			if (age>=21 && carType.equals("small") && LicTime >= 1) {
				sc_amount--;
			}
			else if (age>=25 && carType.equals("large") && LicTime >= 5) {
				lc_amount--;
			}
			else { 
				throw new IllegalArgumentException(
                        "can not rent car " );
			}
		}
		for (Car car : cars) {
			if (car.getType().equals(carType) && !car.isRented()
					&& car.getCurrentFuel()==car.getMaxCapacityOfFuelTank()) {
				car.setRented("isrented");
				record.put(drivingLicence,car);
				break;
			}
		}
		
	}
	
	/** This method terminates the rental contract associated with the given driving licence. In
	 * effect, the driver is returning the car. The car is then available for rent by someone else.
	 * The method removes the record of the rental from the company's records (disassociating  the 
	 * car from the licence) and returns the amount of fuel in Litres required to fill the car's tank.
	 * @param drivingLicence person's driving licence
	 * @return the amount of fuel in Litres required to fill the car's tank
	 */
	public int terminateRental(DriveLicence drivingLicence) {
		Car car=record.get(drivingLicence);
		int fuelToAdd=car.getMaxCapacityOfFuelTank()-car.getCurrentFuel();
		car.setRented("notrented");
		record.remove(drivingLicence);
		return fuelToAdd;
	}
}
