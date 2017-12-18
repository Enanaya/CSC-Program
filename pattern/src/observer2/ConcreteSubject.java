package observer2;

import java.util.Observable;

/**
 * @author 76500 目标对象
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
		state = s;// 目标对象发生了变化
		setChanged();// 表示目标对象已被更改
		notifyObservers(state); //通知所有观察者
	}

}
