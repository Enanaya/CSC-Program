package simplefactory;

/**
 * @author 76500
 * 测试简单工厂模式下
 */
public class Client02 {
	
	public static void main(String[] args) {
		Car c1=CarFactory2.createCar("奥迪");
		Car c2=CarFactory2.createCar("比亚迪");
		
		c1.run();
		c2.run();
	}
}
