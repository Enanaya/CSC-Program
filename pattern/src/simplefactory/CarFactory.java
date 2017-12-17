package simplefactory;

/**
 * @author 76500
 * ¼òµ¥¹¤³§
 */
public class CarFactory {
	public static Car createAudi() {
		return new Audi();
	}
	
	public static Car createByd() {
		return new Byd();
	}
}
