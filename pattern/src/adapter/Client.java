package adapter;

/**
 * @author 76500
 * ¿Í»§¶ËÀà
 */
public class Client {
	public void test01(Target t) {
		t.handleRqe();
	}
	
	public static void main(String[] args) {
		Client client=new Client();
		Target t=new Adapter();
		client.test01(t);
		Target t2=new Adapter2(new Adaptee());
		client.test01(t2);
	}
	
}
