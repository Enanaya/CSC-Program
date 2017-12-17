package testAnnotation.ORM;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 76500
 * 使用反射读取注解信息，模拟处理信息的流程
 */
public class Demo {
	public static void main(String[] args) {
		try {
			
			Class clz=Class.forName("testAnnotation.ORM.Sxtstudent");
			
			//获得类的所有有效注解
			Annotation[] annotations=clz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			//获得类的指定注解
			SxtTable st=(SxtTable) clz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			//获得属性注解
			Field f=clz.getDeclaredField("stuName");
			SxtField sf=f.getAnnotation(SxtField.class);
			System.out.println(sf.columnName()+"--"+sf.type()+"--"+sf.length());
			
			//根据获得的表民，字段信息，拼出ddl语句，然后使用jdbc执行sql
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
