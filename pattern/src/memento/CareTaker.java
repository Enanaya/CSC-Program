package memento;

import java.util.ArrayList;

/**
 * @author 76500 负责人类对象，负责管理备忘录对象
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
