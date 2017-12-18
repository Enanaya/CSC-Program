package mediator;

public class Finacial implements Department {

	private Mediator m; // 持有中介者的引用

	public Finacial(Mediator m) {
		super();
		this.m = m;
		m.register("Finacial", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("我在数钱");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("汇报工作-钱");
	}

}
