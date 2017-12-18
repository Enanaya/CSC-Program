package strategy;

/**
 * @author 76500
 * 负责和具体策略类交互
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	
	public void printPrice(double s) {
		System.out.println("报价:"+strategy.getPrice(s));
	}
}
