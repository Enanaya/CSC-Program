package mediator;

public class Finacial implements Department {

	private Mediator m; // �����н��ߵ�����

	public Finacial(Mediator m) {
		super();
		this.m = m;
		m.register("Finacial", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("������Ǯ");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("�㱨����-Ǯ");
	}

}
