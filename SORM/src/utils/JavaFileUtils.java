package utils;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import bean.ColumnInfo;
import bean.JavaFieldGetSet;
import bean.TableInfo;
import core.DBManager;
import core.MysqlTypeConvertor;
import core.TableContext;
import core.TypeConvertor;

/**
 * ��װ��java�ļ�������Դ���룩
 * 
 * @author ����
 *
 */
public class JavaFileUtils {
	/**
	 * �����ֶ���Ϣ����java������Ϣ����varchar username--?private String username���Լ���Ӧgetset
	 * 
	 * @param column
	 *            �ֶ���Ϣ
	 * @param convertor
	 *            ����ת����
	 * @return java���Ժ�set get����
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();

		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());

		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

		// public String getUsername(){return username;}
		// ����get��Դ����
		StringBuilder getSrc = new StringBuilder();
		getSrc.append(
				"\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + "(){\n");
		getSrc.append("\t\treturn " + column.getName() + ";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());

		// public void setUsername(String username){this.username=username;}
		// ����set��Դ����
		StringBuilder setSrc = new StringBuilder();
		setSrc.append(
				"\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\tthis." + column.getName() + "="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());

		return jfgs;

	}
	
	/**���ݱ���Ϣ����java��Դ����
	 * @param tableInfo ����Ϣ
	 * @param convertor ��������ת����
	 * @return java��Դ����
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor) {
		Map<String, ColumnInfo> columns= tableInfo.getColumns();
		ArrayList<JavaFieldGetSet> javaFields=new ArrayList<JavaFieldGetSet>();
		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		
		StringBuilder src=new StringBuilder();
		
		//����package���
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//����import���
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//�������������
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		//���������б�
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		
		src.append("\n\n");
		//����get�����б�
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
		}
		//����set�����б�
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getSetInfo());
		}
		//���������
		src.append("}\n");
//		System.out.println(src);
		return src.toString();
	}
	
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor) {
		String src= createJavaSrc(tableInfo, convertor);
		String srcPath=DBManager.getConf().getSrcPath()+"\\";
		String poPath=DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		File f=new File(srcPath+poPath+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTname()+".java"));
//		System.out.println(f.getAbsolutePath()+"=========");
//		if (!f.exists()) {//����������򴴽�
//			f.mkdirs();
//		}
		
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(f));
			bw.write(src);
			System.out.println("������"+tableInfo.getTname()+"��Ӧ��java��:"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		/*ColumnInfo ci=new ColumnInfo("username","varchar",0);
		JavaFieldGetSet f= createFieldGetSetSRC(ci, new MysqlTypeConvertor());
		System.out.println(f);*/
		
	}
}
