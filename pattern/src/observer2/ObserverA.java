package observer2;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

	private int mystate;

	public int getMystate() {
		return mystate;
	}

	public void setMystate(int mystate) {
		this.mystate = mystate;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		mystate = ((ConcreteSubject) o).getState();
	}

}
