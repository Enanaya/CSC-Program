package bridge;

/**
 * @author 76500 电脑类型维度
 */
public class Computer2 {
	protected Brand brand;

	public Computer2(Brand brand) {
		super();
		this.brand = brand;
	};

	public void sale() {
		brand.sale();
	}
}

class Desktop2 extends Computer2 {

	public Desktop2(Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		super.sale();
		System.out.println("销售台式机");
	}

}

class Labtop2 extends Computer2 {

	public Labtop2(Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		super.sale();
		System.out.println("销售笔记本");
	}

}