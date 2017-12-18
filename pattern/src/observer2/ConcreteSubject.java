package observer2;

import java.util.Observable;

/**
 * @author 76500 Ŀ�����
 */
public class ConcreteSubject extends Observable {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void set(int s) {
		state = s;// Ŀ��������˱仯
		setChanged();// ��ʾĿ������ѱ�����
		notifyObservers(state); //֪ͨ���й۲���
	}

}
