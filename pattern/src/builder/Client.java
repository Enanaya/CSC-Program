package builder;

public class Client {
	public static void main(String[] args) {
		Director director=new SxtAirShipDiectory(new SxtAirShipBuilder());
		AirShip airShip= director.createrAirShip();
		
		System.out.println(airShip.getEngine().getName());
	}
}
