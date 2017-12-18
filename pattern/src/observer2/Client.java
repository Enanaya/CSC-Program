package observer2;

public class Client {
	public static void main(String[] args) {
		//创建目标对象
		ConcreteSubject subject=new ConcreteSubject();
		
		//创观察者
		ObserverA observerA=new ObserverA();
		ObserverA observerB=new ObserverA();
		ObserverA observerC=new ObserverA();
		
		//加到目标对象观察队列中
		subject.addObserver(observerA);
		subject.addObserver(observerB);
		subject.addObserver(observerC);
		
		subject.set(300);
		System.out.println(observerA.getMystate());
	}
}
