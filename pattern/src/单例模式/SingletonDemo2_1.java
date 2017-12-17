package 单例模式;

import java.io.Serializable;

/**
 * @author 76500 懒汉式单例模式(如何防止反射和反序列漏洞)
 */
public class SingletonDemo2_1 implements Serializable{
	
	// 类初始化时，不加载对象（延时加载，用时才加载
	private static SingletonDemo2_1 instance;

	private SingletonDemo2_1() {// 私有构造器
		// TODO Auto-generated constructor stub
		//一般情况不需要考虑
		if (instance!=null) {
			throw new RuntimeException();
		}
	}

	// 方法同步，调用效率低！
	public static SingletonDemo2_1 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2_1();
		}
		return instance;
	}
}
