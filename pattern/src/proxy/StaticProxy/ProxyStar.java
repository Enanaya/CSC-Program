package proxy.StaticProxy;

public class ProxyStar implements Star{
	private Star star;
	
	public ProxyStar(Star star) {
		// TODO Auto-generated constructor stub
		this.star=star;
	}
	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("Pconfer");
	}

	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		System.out.println("Pconfer");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		star.sing();
	}

	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		System.out.println("Pconfer");
	}

}
