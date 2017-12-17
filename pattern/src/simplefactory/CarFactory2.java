package simplefactory;

public class CarFactory2 {
	public static Car createCar(String type) {
		if (type.equals("°ÂµÏ")) {
			return new Audi();
		}else if ("±ÈÑÇµÏ".equals(type)) {
			return new Byd();
		}else {
			return null;
		}
	}
}
