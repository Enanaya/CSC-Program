package decorator;

/**
 * @author 76500 抽象组件
 */
public interface ICar {
	void move();
}

/**
 * @author 76500 真实对象
 */
class Car implements ICar {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("陆地上跑");
	}

}

class SuperCar implements ICar {
	protected ICar car;

	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		car.move();
	}

}

/**
 * @author 76500
 * 具体装饰对象
 */
class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}

	public void fly() {
		System.out.println("飞");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		fly();
	}

}

class WaterCar extends SuperCar {

	public WaterCar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}

	public void swim() {
		System.out.println("游");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		swim();
	}

}