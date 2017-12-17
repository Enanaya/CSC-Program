package 单例模式;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 76500 测试反射和反序列化破解单例模式
 */
public class Client {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		SingletonDemo02 s1 = SingletonDemo02.getInstance();
		SingletonDemo02 s2 = SingletonDemo02.getInstance();
		System.out.println(s1);
		System.out.println(s2);

		// 通过反射破解
		Class<SingletonDemo02> clz = (Class<SingletonDemo02>) Class.forName("实现方法.SingletonDemo02");

		Constructor<SingletonDemo02> c = clz.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDemo02 s3 = c.newInstance();
		SingletonDemo02 s4 = c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
		
		
		// 成功防止破解，无法运行
		/*Class<SingletonDemo2_1> clz2 = (Class<SingletonDemo2_1>) Class.forName("实现方法.SingletonDemo02");
		Constructor<SingletonDemo2_1> c2 = clz2.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDemo2_1 s5 = c2.newInstance();
		SingletonDemo2_1 s6 = c2.newInstance();
		System.out.println(s5);
		System.out.println(s6);*/
		
		
		// 通过反序列化破解
		FileOutputStream fos=new FileOutputStream("E:/Ser.txt");
		ObjectOutputStream os=new ObjectOutputStream(fos);
		SingletonDemo2_2 s7 = SingletonDemo2_2.getInstance();
		os.writeObject(s7);//能写入数据，但会报错，不知为啥
		fos.close();
		os.close();
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:/Ser.txt"));
		SingletonDemo2_2 s8= (SingletonDemo2_2) ois.readObject();
		System.out.println(s7);
		System.out.println(s8);
	}
}
