package adapter;

/**
 * @author 76500 ����������
 */
public class Adapter2 implements Target {
	private Adaptee adaptee;
	
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	// 2.�������
	@Override
	public void handleRqe() {
		// TODO Auto-generated method stub
		adaptee.request();
	}

}
