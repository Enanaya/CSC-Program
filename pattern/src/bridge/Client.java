package bridge;

public class Client {
	public static void main(String[] args) {
		//��������ʼǱ�
		Computer2 c=new Labtop2(new Lenovo());
		c.sale();
		
		Computer2 c2=new Desktop2(new Dell());
		c2.sale();
	}
}
