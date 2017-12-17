package 单例模式;

/**
 * @author 76500
 * 饿汉式单例模式
 */
public class SingletonDemo01 {

	//初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全，
	//因为只有一个静态对象在内存中
	private static SingletonDemo01 instance=new SingletonDemo01();
	
	private SingletonDemo01() {//私有化构造器
		// TODO Auto-generated constructor stub
	}
	
	//方法没有同步，调用效率高
	public static SingletonDemo01 getInstance() {
		return instance;
	}
}
