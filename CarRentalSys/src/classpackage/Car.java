package classpackage;

public interface Car {
	/** this method returns the car's registration number
	 * @return  this car's registration number
	 */
	String getRegistrationNumber();
	
	/** method to get the capacity in whole Litres of the car's fuel tank, which is 49 Litres
	 *  for a small car and 60 Litres for a large car
	 * @return Car's capacity of fuel tank
	 */
	int getMaxCapacityOfFuelTank();  
	
	/** method to get the amount of fuel in whole Litres currently in the fuel tank
	 * @return current fuel in fuel tank
	 */
	int getCurrentFuel();
	
	/** method that indicates whether the car's fuel tank is full or not
	 * @return true if fuel tank is full
	 */
	boolean isFullFuel();
	
	/** method that indicates whether the car is rented or not
	 * @return true if this car is rented
	 */
	boolean isRented();
	
	void setRented(String status);
	
	/** method to add a given number of whole Litres to the fuel tank (up to the tank's 
	 * capacity) and which, after execution, indicates how much fuel was added to the tank 
	 * (which will be 0 if the car is not rented or its tank is already full)
	 * @param amount the amount of fuel will be given to add to fuel tank
	 * @return actual amount add to fuel tank
	 */
	int addFuel(int amount); 
	
	/** method to "drive" the car for a given number of whole Kilometres that returns the
	 * number of whole Litres of fuel consumed during the journey 
	 * @param km the distance that the car will go
	 * @return  number of whole Litres of fuel consumed during the journey
	 */
	int driveCar(int km);
	
	String getType();
	
}
