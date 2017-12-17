package builder;

public class SxtAirShipDiectory implements Director {
	private AirShipBuilder builder;

	public SxtAirShipDiectory(AirShipBuilder builder) {
		// TODO Auto-generated constructor stub
		this.builder = builder;
	}

	@Override
	public AirShip createrAirShip() {
		// TODO Auto-generated method stub
		
		engine e= builder.builderEngine();
		orbtialModule o=builder.buildOrbtialModule();
		escapeTower es=builder.builderescapeTower();
		
		AirShip ship=new AirShip();
		ship.setEngine(e);
		ship.setEscapeTower(es);
		ship.setEngine(e);
		return ship;
	}

}
