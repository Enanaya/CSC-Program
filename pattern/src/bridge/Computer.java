package bridge;

public interface Computer {
	void sale();
}

class Desktop implements Computer {

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("����̨ʽ��");
	}
}

class Laptop implements Computer {

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("���۱ʼǱ�");
	}

}

class Pad implements Computer {

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("����ƽ��");
	}

}

class LenovoDesktop extends Desktop{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("��������̨ʽ��");
	}
}

class LenoveLabtop extends Laptop{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("��������ʼǱ�");
	}
}

//�ȵ�