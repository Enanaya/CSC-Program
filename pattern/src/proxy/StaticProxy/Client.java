package proxy.StaticProxy;

public class Client {
	public static void main(String[] args) {
		Star realstar=new RealStar();
		Star proxy=new ProxyStar(realstar);
		proxy.confer();
		proxy.collectMoney();
		proxy.sing();
	}
}
