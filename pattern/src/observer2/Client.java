package observer2;

public class Client {
	public static void main(String[] args) {
		//����Ŀ�����
		ConcreteSubject subject=new ConcreteSubject();
		
		//���۲���
		ObserverA observerA=new ObserverA();
		ObserverA observerB=new ObserverA();
		ObserverA observerC=new ObserverA();
		
		//�ӵ�Ŀ�����۲������
		subject.addObserver(observerA);
		subject.addObserver(observerB);
		subject.addObserver(observerC);
		
		subject.set(300);
		System.out.println(observerA.getMystate());
	}
}
