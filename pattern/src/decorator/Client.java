package decorator;

public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		System.out.println("新的功能---飞行");
		
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		
		System.out.println("增加水里游----");
		WaterCar waterCar = new WaterCar(flyCar);
		waterCar.move();
		
		//重组功能
		System.out.println("重组");
		WaterCar waterCar2 = new WaterCar(new FlyCar(car));
		waterCar2.move();
	}
}
