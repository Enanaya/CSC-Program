package mediator;

public interface Mediator {
	void register(String name,Department d);
	void command(String name);
}
