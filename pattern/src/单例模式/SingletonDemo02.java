package 单例模式;

/**
 * @author 76500 懒汉式单例模式
 */
public class SingletonDemo02 {
	
	// 类初始化时，不加载对象（延时加载，用时才加载
	private static SingletonDemo02 instance;

	private SingletonDemo02() {// 私有构造器
		// TODO Auto-generated constructor stub
	}

	// 方法同步，调用效率低！
	public static SingletonDemo02 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo02();
		}
		return instance;
	}
}
