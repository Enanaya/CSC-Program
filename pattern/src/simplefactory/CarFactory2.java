package simplefactory;

public class CarFactory2 {
	public static Car createCar(String type) {
		if (type.equals("�µ�")) {
			return new Audi();
		}else if ("���ǵ�".equals(type)) {
			return new Byd();
		}else {
			return null;
		}
	}
}
