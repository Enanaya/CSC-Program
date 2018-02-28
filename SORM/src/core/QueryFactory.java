package core;

/**
 * 创建Query的工厂类
 * 
 * @author 76500
 *
 */
public class QueryFactory {

	private static QueryFactory factory = new QueryFactory();
	private static Query prototypeObj; //原型对象
	static {
		
		try {
			 Class c = Class.forName(DBManager.getConf().getQueryClass()); //加载指定的query类
			 prototypeObj=(Query) c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private QueryFactory() {// 私有构造器
		
	}

	public static Query createQuery() {
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
