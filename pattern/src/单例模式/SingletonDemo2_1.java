package ����ģʽ;

import java.io.Serializable;

/**
 * @author 76500 ����ʽ����ģʽ(��η�ֹ����ͷ�����©��)
 */
public class SingletonDemo2_1 implements Serializable{
	
	// ���ʼ��ʱ�������ض�����ʱ���أ���ʱ�ż���
	private static SingletonDemo2_1 instance;

	private SingletonDemo2_1() {// ˽�й�����
		// TODO Auto-generated constructor stub
		//һ���������Ҫ����
		if (instance!=null) {
			throw new RuntimeException();
		}
	}

	// ����ͬ��������Ч�ʵͣ�
	public static SingletonDemo2_1 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2_1();
		}
		return instance;
	}
}
