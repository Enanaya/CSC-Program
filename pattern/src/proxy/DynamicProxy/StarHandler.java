package proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

	Star realstar;

	public StarHandler(Star realstar) {
		super();
		this.realstar = realstar;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object object=null;
		if (method.getName().equals("sing")) {
			object=method.invoke(realstar, args);
		}/*else {
			method.invoke(proxy, args);
		}*/
		
		return object;
	}

}
