package flyweight;

/**
 * @author 76500
 * ��Ԫ��
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
		System.out.println("������ɫ"+color);
		System.out.println("����λ��"+c.getX()+"---"+c.getY());
	}
	
}