package strategy;

public class Client {	
	public static void main(String[] args) {
		Strategy s1=new NewCustomerFewStrategy();
		Context context=new Context(s1);
		context.printPrice(998);
		Strategy s2=new NewCustomerManyStrategy();
		Context context2=new Context(s2);
		context2.printPrice(800);
	}
}
