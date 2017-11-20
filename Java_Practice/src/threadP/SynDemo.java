package threadP;

/**
 * @author 76500 单例设计模式：确保一个类只有一个对象
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
 * 单例设计模式
 * 
 * @author 76500 懒汉式
 */
class Jvm {
	// 声明一个私有的静态变量
	private static Jvm instance = null;

	// 构造器私有化，避免外部直接创建对象
	private Jvm() {
	}

	// 创建一个对外的公共的静态方法访问变量，如果变量没有对象，则创建
	public static Jvm getInstance(long time) throws InterruptedException {
		if (null == instance) {  //双重检查
			synchronized (Jvm.class) {
				if (null == instance) {
					Thread.sleep(time);// 延时，放大发生错误概率
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
			System.out.println(Thread.currentThread().getName() + "---->创建对象： " + Jvm.getInstance(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}