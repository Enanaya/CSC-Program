package builder;

public class SxtAirShipBuilder implements AirShipBuilder{

	@Override
	public engine builderEngine() {
		// TODO Auto-generated method stub
		System.out.println("����������");
		return new engine("���޷�����");
	}

	@Override
	public orbtialModule buildOrbtialModule() {
		// TODO Auto-generated method stub
		System.out.println("���������");
		return new orbtialModule("���޹����");
	}

	@Override
	public escapeTower builderescapeTower() {
		// TODO Auto-generated method stub
		System.out.println("����������");
		return new escapeTower("����������");
	}
	
}
