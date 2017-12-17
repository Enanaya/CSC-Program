package testAnnotation.ORM;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 76500
 * ʹ�÷����ȡע����Ϣ��ģ�⴦����Ϣ������
 */
public class Demo {
	public static void main(String[] args) {
		try {
			
			Class clz=Class.forName("testAnnotation.ORM.Sxtstudent");
			
			//������������Чע��
			Annotation[] annotations=clz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			//������ָ��ע��
			SxtTable st=(SxtTable) clz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			//�������ע��
			Field f=clz.getDeclaredField("stuName");
			SxtField sf=f.getAnnotation(SxtField.class);
			System.out.println(sf.columnName()+"--"+sf.type()+"--"+sf.length());
			
			//���ݻ�õı����ֶ���Ϣ��ƴ��ddl��䣬Ȼ��ʹ��jdbcִ��sql
			
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
