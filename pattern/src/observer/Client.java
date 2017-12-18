package observer;

public class Client {
	public static void main(String[] args) {
		//Ŀ�����
		ConcreteSubject subject=new ConcreteSubject();
		//�۲����
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		ObserverA obs3=new ObserverA();
		ObserverA obs4=new ObserverA();
		
		//���������۲�����ӵ�subject�Ĺ۲��߶�����
		subject.register(obs1);
		subject.register(obs2);
		subject.register(obs3);
		subject.register(obs4);
		
		//�ı�subject��״̬
		subject.setState(300);
		//���Թ۲��ߵ�״̬
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());
		System.out.println(obs3.getMystate());
	}
}
