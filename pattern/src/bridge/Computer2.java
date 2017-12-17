package bridge;

/**
 * @author 76500 ��������ά��
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
		System.out.println("����̨ʽ��");
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
		System.out.println("���۱ʼǱ�");
	}

}