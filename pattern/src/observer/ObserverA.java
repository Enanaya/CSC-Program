package observer;

public class ObserverA implements Observer {

	private int mystate; // Ҫ��Ŀ�����stateһ��

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
