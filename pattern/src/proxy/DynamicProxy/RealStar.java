package proxy.DynamicProxy;

public class RealStar implements Star{

	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("Rconfer");
	}

	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		System.out.println("RsignContract");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("Rsing");
	}

	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		System.out.println("RcollectMoney");
	} 
	
}
