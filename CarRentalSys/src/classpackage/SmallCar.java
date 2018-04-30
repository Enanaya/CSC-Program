package classpackage;

public class SmallCar extends CarFactory{
	
	/**
     *  small car : 49 
     */
    private final int CapacityOfFuel=49;
	
    private final static int fuelConsume=20;
    
	public SmallCar(String reg_number,int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		super(reg_number,CapacityOfFuel);
	}

	@Override
	public int driveCar(int km) {
		// TODO Auto-generated method stub
		if (km<0) {
			throw new IllegalArgumentException("negative distance");
		}
		
		if (isRented() && getCurrentFuel()>0) {
			int fuelUse=(int) Math.ceil((double)km/fuelConsume);
			return fuelUse<getCurrentFuel()?fuelUse:getCurrentFuel();
		}
		return -1;
	}

	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "small";
	}
}
