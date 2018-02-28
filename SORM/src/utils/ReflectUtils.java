package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ��װ���䳣�õĲ���
 * 
 * @author ����
 *
 */
public class ReflectUtils {

	/**
	 * ����obj���󣬶�Ӧ����Ϊfield��get����
	 * 
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		// ͨ��������Ƶ������Զ�Ӧ��get/set����
		try {
			Class c = obj.getClass();
			Method method = c.getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
			return method.invoke(obj, null);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Object invokeSet(Object obj, String fieldName,Object columnValue) {
		if (columnValue!=null) {
			
		Class c = obj.getClass();
		Method m;
		try {
			m = c.getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(fieldName), columnValue.getClass());
			return m.invoke(obj, columnValue);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
	}
}
