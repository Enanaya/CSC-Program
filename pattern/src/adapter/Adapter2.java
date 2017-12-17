package adapter;

/**
 * @author 76500 适配器本身
 */
public class Adapter2 implements Target {
	private Adaptee adaptee;
	
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	// 2.对象组合
	@Override
	public void handleRqe() {
		// TODO Auto-generated method stub
		adaptee.request();
	}

}
