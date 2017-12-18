package observer;

public class ObserverA implements Observer {

	private int mystate; // 要跟目标对象state一致

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		mystate = ((ConcreteSubject) subject).getState();
	}

	public int getMystate() {
		return mystate;
	}

	public void setMystate(int mystate) {
		this.mystate = mystate;
	}

}
