package observer;

public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject=new ConcreteSubject();
		//观察对象
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		ObserverA obs3=new ObserverA();
		ObserverA obs4=new ObserverA();
		
		//将这三个观察者添加到subject的观察者队伍中
		subject.register(obs1);
		subject.register(obs2);
		subject.register(obs3);
		subject.register(obs4);
		
		//改变subject的状态
		subject.setState(300);
		//测试观察者的状态
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());
		System.out.println(obs3.getMystate());
	}
}
