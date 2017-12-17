package prototype;

import java.util.Date;

/**
 * @author 76500 ����ԭ��ģʽ
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(2424525);
		Sheep s1=new Sheep("����", date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		Sheep s2=(Sheep) s1.clone();
		
		s1.setBirthday(new Date(242342345));
		System.out.println(s1.getBirthday());
		
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}

}
