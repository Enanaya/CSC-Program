package simplefactory;

/**
 * @author 76500
 * �򵥹���
 */
public class CarFactory {
	public static Car createAudi() {
		return new Audi();
	}
	
	public static Car createByd() {
		return new Byd();
	}
}
