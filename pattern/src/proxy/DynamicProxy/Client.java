package proxy.DynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star realstar=new RealStar();
		StarHandler starHandler=new StarHandler(realstar);
		Star proxy=(Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, starHandler);
		
		proxy.collectMoney();
		proxy.sing();
	}
}
