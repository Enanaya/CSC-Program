package simplefactory;

/**
 * @author 76500
 * ������û�й���ģʽ��
 */
public class Client01 {
	
	public static void main(String[] args) {
		Car c1=new Audi();
		Car c2=new Byd();
		
		c1.run();
		c2.run();
	}
}
