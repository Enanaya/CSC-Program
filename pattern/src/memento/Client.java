package memento;

public class Client {
	public static void main(String[] args) {
		CareTaker careTaker=new CareTaker();
		
		Emp emp=new Emp("����", 22, 1242);
		System.out.println("��һ�δ�������"+emp.getEname()+emp.getAge()+emp.getSalary());
		careTaker.setMemento(emp.memento()); //����һ�α���
		
		emp.setAge(35);
		emp.setEname("ŷ��");
		System.out.println("�ڶ��δ�������"+emp.getEname()+emp.getAge()+emp.getSalary());
		emp.recovery(careTaker.getMemento()); //�ָ�������¼�����״̬
		System.out.println("�����δ�������"+emp.getEname()+emp.getAge()+emp.getSalary());
	}
}
