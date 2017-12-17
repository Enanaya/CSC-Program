package builder;

public class SxtAirShipBuilder implements AirShipBuilder{

	@Override
	public engine builderEngine() {
		// TODO Auto-generated method stub
		System.out.println("构建发动机");
		return new engine("非洲发动机");
	}

	@Override
	public orbtialModule buildOrbtialModule() {
		// TODO Auto-generated method stub
		System.out.println("构建轨道舱");
		return new orbtialModule("非洲轨道舱");
	}

	@Override
	public escapeTower builderescapeTower() {
		// TODO Auto-generated method stub
		System.out.println("构建逃生舱");
		return new escapeTower("非洲逃生舱");
	}
	
}
