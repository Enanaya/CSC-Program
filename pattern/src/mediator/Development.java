package mediator;

public class Development implements Department {

	private Mediator m; // �����н��ߵ�����

	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("ר�Ŀ���");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("�㱨����");
	}

}
