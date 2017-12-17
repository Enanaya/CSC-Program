package 单例模式;

/**
 * @author 76500 静态内部类实现单例模式,属于懒加载,重要
 */
public class SingletonDemo3 {
	
	private static class SingletonClassInstance{
		private static final SingletonDemo3 instance=new SingletonDemo3();  
	}
	
	private SingletonDemo3() {// 私有构造器
		// TODO Auto-generated constructor stub
	}

	//方法没有同步，效率高
	public static SingletonDemo3 getInstance() {
		return SingletonClassInstance.instance;
	}
}
