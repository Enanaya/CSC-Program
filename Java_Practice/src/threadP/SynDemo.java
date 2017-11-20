package threadP;

/**
 * @author 76500 �������ģʽ��ȷ��һ����ֻ��һ������
 */
public class SynDemo {
	public static void main(String[] args) {
		// Jvm jvm1=Jvm.getInstance();
		// Jvm jvm2=Jvm.getInstance();
		// System.out.println(jvm1);
		// System.out.println(jvm2);

		JvmThread thread = new JvmThread(100);
		JvmThread thread1 = new JvmThread(500);

		thread.start();
		thread1.start();
	}
}

/**
 * �������ģʽ
 * 
 * @author 76500 ����ʽ
 */
class Jvm {
	// ����һ��˽�еľ�̬����
	private static Jvm instance = null;

	// ������˽�л��������ⲿֱ�Ӵ�������
	private Jvm() {
	}

	// ����һ������Ĺ����ľ�̬�������ʱ������������û�ж����򴴽�
	public static Jvm getInstance(long time) throws InterruptedException {
		if (null == instance) {  //˫�ؼ��
			synchronized (Jvm.class) {
				if (null == instance) {
					Thread.sleep(time);// ��ʱ���Ŵ����������
					instance = new Jvm();
				}
			}
		}
		return instance;
	}
}

class JvmThread extends Thread {
	private long time;

	public JvmThread() {
		// TODO Auto-generated constructor stub
	}

	public JvmThread(long time) {
		this.time = time;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println(Thread.currentThread().getName() + "---->�������� " + Jvm.getInstance(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}