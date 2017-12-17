package bridge;

public interface Computer {
	void sale();
}

class Desktop implements Computer {

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售台式机");
	}
}

class Laptop implements Computer {

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售笔记本");
	}

}

class Pad implements Computer {

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售平板");
	}

}

class LenovoDesktop extends Desktop{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售联想台式机");
	}
}

class LenoveLabtop extends Laptop{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售联想笔记本");
	}
}

//等等