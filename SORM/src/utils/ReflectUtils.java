package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装反射常用的操作
 * 
 * @author 非洲
 *
 */
public class ReflectUtils {

	/**
	 * 调用obj对象，对应属性为field的get方法
	 * 
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		// 通过反射机制调用属性对应的get/set方法
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
