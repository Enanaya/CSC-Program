package ����ģʽ;

/**
 * @author 76500 ����ʽ����ģʽ(��η�ֹ����ͷ�����©��)
 */
public class SingletonDemo2_2 {
	
	// ���ʼ��ʱ�������ض�����ʱ���أ���ʱ�ż���
	private static SingletonDemo2_2 instance;

	private SingletonDemo2_2() {// ˽�й�����
		// TODO Auto-generated constructor stub
		//һ���������Ҫ����
		if (instance!=null) {
			throw new RuntimeException();
		}
	}

	// ����ͬ��������Ч�ʵͣ�
	public static SingletonDemo2_2 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2_2();
		}
		return instance;
	}
}
