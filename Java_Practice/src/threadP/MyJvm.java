package threadP;

public class MyJvm {
	private static MyJvm instance;

	private MyJvm() {

	}

	public static MyJvm getInstance() {
		if (null == instance) {
			synchronized (MyJvm.class) {
				if (null == instance) {
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
}

// ����ʽ �̰߳�ȫ��ֻ����д
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();// ����˽�о�̬����ͬʱ��������

	private MyJvm2() {

	}

	public static MyJvm2 getInstance() {
		return instance;
	}
}

// ����ʹ��ʱ�ż��أ��ӻ�����ʱ��
class MyJvm3 {
	private static class Jvholder {
		private static MyJvm3 instance = new MyJvm3();// ����˽�о�̬����ͬʱ��������
	}

	private MyJvm3() {

	}

	public static MyJvm3 getInstance() {
		return Jvholder.instance;
	}

}