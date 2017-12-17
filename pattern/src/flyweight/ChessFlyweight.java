package flyweight;

/**
 * @author 76500
 * 享元类
 */
public interface ChessFlyweight {
	void setColor(String c);
	String getColor();
	void display(Coordinate c);
}

class ConcreteChess implements ChessFlyweight{

	private String color;
	@Override
	public void setColor(String c) {
		// TODO Auto-generated method stub
		this.color=c;
	}

	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void display(Coordinate c) {
		// TODO Auto-generated method stub
		System.out.println("棋子颜色"+color);
		System.out.println("棋子位置"+c.getX()+"---"+c.getY());
	}
	
}