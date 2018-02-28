package core;

/**
 * ����Query�Ĺ�����
 * 
 * @author 76500
 *
 */
public class QueryFactory {

	private static QueryFactory factory = new QueryFactory();
	private static Query prototypeObj; //ԭ�Ͷ���
	static {
		
		try {
			 Class c = Class.forName(DBManager.getConf().getQueryClass()); //����ָ����query��
			 prototypeObj=(Query) c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private QueryFactory() {// ˽�й�����
		
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
