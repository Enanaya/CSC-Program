package ����ģʽ;

/**
 * @author 76500
 * ����ʽ����ģʽ
 */
public class SingletonDemo01 {

	//��ʼ��ʱ�����������������û����ʱ���ص����ƣ���������ʱ����Ȼ�����̰߳�ȫ��
	//��Ϊֻ��һ����̬�������ڴ���
	private static SingletonDemo01 instance=new SingletonDemo01();
	
	private SingletonDemo01() {//˽�л�������
		// TODO Auto-generated constructor stub
	}
	
	//����û��ͬ��������Ч�ʸ�
	public static SingletonDemo01 getInstance() {
		return instance;
	}
}
