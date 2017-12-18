package observer;

import java.awt.List;
import java.util.ArrayList;

public class Subject {
	protected ArrayList<Observer> list = new ArrayList<Observer>();

	public void register(Observer obs) {
		list.add(obs);
	}

	public void remove(Observer obs) {
		list.remove(obs);
	}
	
	//֪ͨ���й۲��߸���״̬
	public void notifyAllObserver() {
		for (Observer observer : list) {
			observer.update(this);
		}
	}
}
