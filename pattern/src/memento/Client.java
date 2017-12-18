package memento;

public class Client {
	public static void main(String[] args) {
		CareTaker careTaker=new CareTaker();
		
		Emp emp=new Emp("非洲", 22, 1242);
		System.out.println("第一次创建对象："+emp.getEname()+emp.getAge()+emp.getSalary());
		careTaker.setMemento(emp.memento()); //做了一次备份
		
		emp.setAge(35);
		emp.setEname("欧洲");
		System.out.println("第二次创建对象："+emp.getEname()+emp.getAge()+emp.getSalary());
		emp.recovery(careTaker.getMemento()); //恢复到备忘录保存的状态
		System.out.println("第三次创建对象："+emp.getEname()+emp.getAge()+emp.getSalary());
	}
}
