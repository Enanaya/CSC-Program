package simplefactory;

/**
 * @author 76500
 * ���Լ򵥹���ģʽ��
 */
public class Client02 {
	
	public static void main(String[] args) {
		Car c1=CarFactory2.createCar("�µ�");
		Car c2=CarFactory2.createCar("���ǵ�");
		
		c1.run();
		c2.run();
	}
}
