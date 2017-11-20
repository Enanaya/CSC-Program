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

// 饿汉式 线程安全，只读不写
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();// 声明私有静态属性同时创建对象

	private MyJvm2() {

	}

	public static MyJvm2 getInstance() {
		return instance;
	}
}

// 类在使用时才加载，延缓加载时机
class MyJvm3 {
	private static class Jvholder {
		private static MyJvm3 instance = new MyJvm3();// 声明私有静态属性同时创建对象
	}

	private MyJvm3() {

	}

	public static MyJvm3 getInstance() {
		return Jvholder.instance;
	}

}