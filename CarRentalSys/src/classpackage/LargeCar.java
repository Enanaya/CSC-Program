package classpackage;

 final class LargeCar extends CarFactory{
	
	/**
     * large car : 60 
     */
    private final int CapacityOfFuel=60;
	
	public LargeCar(String reg_number,int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		super(reg_number,CapacityOfFuel);
	}

	@Override
	public int driveCar(int km) {
		// TODO Auto-generated method stub
		return 0;
	}
}
