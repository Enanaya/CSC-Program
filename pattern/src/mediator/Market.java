package mediator;

public class Market implements Department {

	private Mediator m; // 持有中介者的引用

	public Market(Mediator m) {
		super();
		this.m = m;
		m.register("Market", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("我在卖货");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("汇报工作-市场");
	}

}
