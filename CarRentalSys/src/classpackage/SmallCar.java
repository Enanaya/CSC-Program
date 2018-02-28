package classpackage;

public class SmallCar extends CarFactory{
	
	/**
     *  small car : 49 
     */
    private final int CapacityOfFuel=49;
	
	public SmallCar(String reg_number,int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		super(reg_number,CapacityOfFuel);
	}

	@Override
	public int driveCar(int km) {
		// TODO Auto-generated method stub
		return 0;
	}

}
