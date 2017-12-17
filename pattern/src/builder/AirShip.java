package builder;

public class AirShip {
	private orbtialModule orbtialModule; // 轨道舱
	private engine engine; // 发动机
	private escapeTower escapeTower; // 逃生舱

	public orbtialModule getOrbtialModule() {
		return orbtialModule;
	}

	public void setOrbtialModule(orbtialModule orbtialModule) {
		this.orbtialModule = orbtialModule;
	}

	public engine getEngine() {
		return engine;
	}

	public void setEngine(engine engine) {
		this.engine = engine;
	}

	public escapeTower getEscapeTower() {
		return escapeTower;
	}

	public void setEscapeTower(escapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}

}
