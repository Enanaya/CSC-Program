package ����ģʽ;

/**
 * @author 76500 ��̬�ڲ���ʵ�ֵ���ģʽ,����������,��Ҫ
 */
public class SingletonDemo3 {
	
	private static class SingletonClassInstance{
		private static final SingletonDemo3 instance=new SingletonDemo3();  
	}
	
	private SingletonDemo3() {// ˽�й�����
		// TODO Auto-generated constructor stub
	}

	//����û��ͬ����Ч�ʸ�
	public static SingletonDemo3 getInstance() {
		return SingletonClassInstance.instance;
	}
}
