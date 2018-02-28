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
 * 封装了java文件操作（源代码）
 * 
 * @author 非洲
 *
 */
public class JavaFileUtils {
	/**
	 * 根据字段信息生成java属性信息，如varchar username--?private String username；以及相应getset
	 * 
	 * @param column
	 *            字段信息
	 * @param convertor
	 *            类型转化器
	 * @return java属性和set get方法
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();

		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());

		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

		// public String getUsername(){return username;}
		// 生成get的源代码
		StringBuilder getSrc = new StringBuilder();
		getSrc.append(
				"\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + "(){\n");
		getSrc.append("\t\treturn " + column.getName() + ";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());

		// public void setUsername(String username){this.username=username;}
		// 生成set的源代码
		StringBuilder setSrc = new StringBuilder();
		setSrc.append(
				"\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\tthis." + column.getName() + "="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());

		return jfgs;

	}
	
	/**根据表信息生成java类源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转换器
	 * @return java类源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor) {
		Map<String, ColumnInfo> columns= tableInfo.getColumns();
		ArrayList<JavaFieldGetSet> javaFields=new ArrayList<JavaFieldGetSet>();
		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		
		StringBuilder src=new StringBuilder();
		
		//生产package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//生产import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//生产类声明语句
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		//生产属性列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		
		src.append("\n\n");
		//生产get方法列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
		}
		//生产set方法列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getSetInfo());
		}
		//生成类结束
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
//		if (!f.exists()) {//如果不存在则创建
//			f.mkdirs();
//		}
		
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(f));
			bw.write(src);
			System.out.println("建立表"+tableInfo.getTname()+"对应的java类:"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
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
