package ����ģʽ;

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
 * @author 76500 ���Է���ͷ����л��ƽⵥ��ģʽ
 */
public class Client {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		SingletonDemo02 s1 = SingletonDemo02.getInstance();
		SingletonDemo02 s2 = SingletonDemo02.getInstance();
		System.out.println(s1);
		System.out.println(s2);

		// ͨ�������ƽ�
		Class<SingletonDemo02> clz = (Class<SingletonDemo02>) Class.forName("ʵ�ַ���.SingletonDemo02");

		Constructor<SingletonDemo02> c = clz.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDemo02 s3 = c.newInstance();
		SingletonDemo02 s4 = c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
		
		
		// �ɹ���ֹ�ƽ⣬�޷�����
		/*Class<SingletonDemo2_1> clz2 = (Class<SingletonDemo2_1>) Class.forName("ʵ�ַ���.SingletonDemo02");
		Constructor<SingletonDemo2_1> c2 = clz2.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDemo2_1 s5 = c2.newInstance();
		SingletonDemo2_1 s6 = c2.newInstance();
		System.out.println(s5);
		System.out.println(s6);*/
		
		
		// ͨ�������л��ƽ�
		FileOutputStream fos=new FileOutputStream("E:/Ser.txt");
		ObjectOutputStream os=new ObjectOutputStream(fos);
		SingletonDemo2_2 s7 = SingletonDemo2_2.getInstance();
		os.writeObject(s7);//��д�����ݣ����ᱨ����֪Ϊɶ
		fos.close();
		os.close();
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:/Ser.txt"));
		SingletonDemo2_2 s8= (SingletonDemo2_2) ois.readObject();
		System.out.println(s7);
		System.out.println(s8);
	}
}
