package memento;

import java.util.ArrayList;

/**
 * @author 76500 ����������󣬸��������¼����
 */
public class CareTaker {

	private EmpMemento memento;
	
	private ArrayList<EmpMemento> list=new ArrayList<EmpMemento>();

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}

}
