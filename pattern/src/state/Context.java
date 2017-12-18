package state;

public class Context {
	private State state;

	public void setState(State state) {
		System.out.println("ÐÞ¸Ä×´Ì¬");
		this.state = state;
		this.state.handle();
	}
}
