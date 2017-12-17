package reflect;

/**
 * @author 76500
 * 获取结构信息class对象源头
 */
public class demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str="abc";
		//class对象
		Class<?> clz=str.getClass();
		//类.class
		clz=String.class;
		//完整路径
		clz=Class.forName("java.lang.String");
	}
}
