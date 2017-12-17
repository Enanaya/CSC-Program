package decorator;

public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		System.out.println("�µĹ���---����");
		
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		
		System.out.println("����ˮ����----");
		WaterCar waterCar = new WaterCar(flyCar);
		waterCar.move();
		
		//���鹦��
		System.out.println("����");
		WaterCar waterCar2 = new WaterCar(new FlyCar(car));
		waterCar2.move();
	}
}
