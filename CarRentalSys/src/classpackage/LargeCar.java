package classpackage;

final class LargeCar extends CarFactory {

	/**
	 * large car : 60
	 */
	private final int CapacityOfFuel = 60;

	private final static int fuelConsumeIn50k = 10;

	private final static int fuelConsume = 15;

	public LargeCar(String reg_number, int CapacityOfFuel) {
		// TODO Auto-generated constructor stub
		super(reg_number, CapacityOfFuel);
	}

	@Override
	public int driveCar(int km) {
		// TODO Auto-generated method stub
		if (km < 0) {
			throw new IllegalArgumentException("negative distance");
		}
		int fuelUse = 0;
		if (isRented() && getCurrentFuel() > 0) {
			if (km < 50) {
				fuelUse = (int) Math.ceil((double) km / fuelConsume);
			} else {
				fuelUse = (int) Math.ceil((((double) km) - 50) / fuelConsume) + 50 * fuelConsumeIn50k;
			}

			if (fuelUse < getCurrentFuel()) {
				fuelConsume(fuelUse);
			} else {
				fuelUse = getCurrentFuel();
				fuelConsume(fuelUse);
			}
		}
		return fuelUse;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "large";
	}
}
