package strategy;

public class NewCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		// TODO Auto-generated method stub
		System.out.println("不打折，原价");
		return standardPrice;
	}

}
