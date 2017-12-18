package mediator;

public class Market implements Department {

	private Mediator m; // �����н��ߵ�����

	public Market(Mediator m) {
		super();
		this.m = m;
		m.register("Market", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("�㱨����-�г�");
	}

}
