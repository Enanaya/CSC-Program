package ����ģʽ;

/**
 * @author 76500 ����ʽ����ģʽ
 */
public class SingletonDemo02 {
	
	// ���ʼ��ʱ�������ض�����ʱ���أ���ʱ�ż���
	private static SingletonDemo02 instance;

	private SingletonDemo02() {// ˽�й�����
		// TODO Auto-generated constructor stub
	}

	// ����ͬ��������Ч�ʵͣ�
	public static SingletonDemo02 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo02();
		}
		return instance;
	}
}
