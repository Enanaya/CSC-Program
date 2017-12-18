package state;

public class Client {
	public static void main(String[] args) {
		Context cxt=new Context();
		cxt.setState(new FreeState());
	}
}
