package prototype;

import java.util.Date;


/**
 * @author 76500 原型模式 深复制  //感觉有误!!!!!
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(2424525);
		Sheep2 s1=new Sheep2("多利", date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		Sheep2 s2=(Sheep2) s1.clone();
		
		s1.setBirthday(new Date(242342345));
		System.out.println(s1.getBirthday());
		
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
