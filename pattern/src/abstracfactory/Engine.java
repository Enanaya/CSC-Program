package abstracfactory;

public interface Engine {
	void run();
	void start();
}

class LuxuryEngine implements Engine{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ת�ÿ�");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	
}

class LowEngine implements Engine{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ת����");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	
}
