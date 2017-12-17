package ����ģʽ;

import java.io.ObjectStreamException;

/**
 * @author 76500 ����ʽ����ģʽ(��η�ֹ����ͷ�����©��)
 */
public class SingletonDemo2_3 {
	
	// ���ʼ��ʱ�������ض�����ʱ���أ���ʱ�ż���
	private static SingletonDemo2_3 instance;

	private SingletonDemo2_3() {// ˽�й�����
		// TODO Auto-generated constructor stub
		//һ���������Ҫ����
		if (instance!=null) {
			throw new RuntimeException();
		}
	}

	// ����ͬ��������Ч�ʵͣ�
	public static SingletonDemo2_3 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2_3();
		}
		return instance;
	}
	
	
	//��ֹ�����л��ƽ� ֱ�ӷ���ָ���Ķ��󣬶�����Ҫ�����ٴ����¶���
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}
