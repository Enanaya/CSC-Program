package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 76500
 * ��Ԫ������
 */
public class ChessFlyWeightFactory {
	//��Ԫ ��
	private static Map<String, ChessFlyweight> map=new HashMap<String,ChessFlyweight>();
	public static ChessFlyweight getChess(String color) {
		if (map.get(color)!=null) {
			return map.get(color);
		}else {
			ChessFlyweight chess=new ConcreteChess(color);
			map.put(color, chess);
			return chess;
		}
	}
}
