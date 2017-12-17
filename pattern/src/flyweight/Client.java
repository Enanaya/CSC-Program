package flyweight;

public class Client {
	public static void main(String[] args) {
		ChessFlyweight c1= ChessFlyWeightFactory.getChess("��ɫ");
		ChessFlyweight c2= ChessFlyWeightFactory.getChess("��ɫ");
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println("�����ⲿ״̬����");
		c1.display(new Coordinate(10, 10));
		c2.display(new Coordinate(20, 10));
	}
}
