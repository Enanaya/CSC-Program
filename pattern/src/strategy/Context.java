package strategy;

/**
 * @author 76500
 * ����;�������ཻ��
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	
	public void printPrice(double s) {
		System.out.println("����:"+strategy.getPrice(s));
	}
}
