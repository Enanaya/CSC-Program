package reflect;

/**
 * @author 76500
 * ��ȡ�ṹ��Ϣclass����Դͷ
 */
public class demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str="abc";
		//class����
		Class<?> clz=str.getClass();
		//��.class
		clz=String.class;
		//����·��
		clz=Class.forName("java.lang.String");
	}
}
