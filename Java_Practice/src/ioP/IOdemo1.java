package ioP;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class IOdemo1 {

	public static void main(String[] args) throws IOException {
	
		//		test01();
//		test02();
		////////////
		String path="E:/iotest";
		File src = new File(path);
		//test03(src);
		test04();
		System.out.println(Arrays.toString(File.listRoots()));
	}

	public static void test01() {
		// System.out.println(File.pathSeparator);
		String path = "E:/iotest";
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());
		System.out.println(src.getName());
		System.out.println(src.isDirectory());
		System.out.println(src.canRead());
		System.out.println(src.canWrite());
		System.out.println(src.canExecute());
		
		
	}

	public static void test02() throws IOException {
		String path = "E:/iotest/createtest";
		File src = new File(path);
		boolean flag = src.createNewFile()  ;
		System.out.println(flag);
		
		File src1=new File("E:/iotest", "mkdir");
		boolean flag2= src1.mkdir();
		System.out.println(flag2);
	}
	
	public static void test03(File src) {
		if (src==null||!src.exists()) {
			return;
		}
		else {
			
		for (File file : src.listFiles()) {
			if (file.isDirectory()) {
				System.out.print("----");
			}
			System.out.println(file.getName());
			test03(file);
		}
		}
		
	}
	
	public static void test04() {
		String path="E:/iotest";
		File src=new File(path);
		File[] subfile=src.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
//				System.out.println(dir.getAbsolutePath());
//				System.out.println(name.endsWith("java"));
				return new File(dir,name).isFile() || name.endsWith("png");
			}
			
		});
		for (File file : subfile) {
			System.out.println(file.getName());
		}
	}
	
	/**
	 * 文件夹拷贝
	 */
	public static void test05() {
		
		String srcPath="E:\\iotest\\io2";
		File src=new File(srcPath);
		String destPaht="E/iotest/mkdir";
		File dest=new File(destPaht);
		
		if (src.isDirectory()) {
			dest=new File(dest, src.getName());
			src.mkdirs();
			//获取下一级
			for (File subfile : src.listFiles()) {
				System.out.println("是文件则复制，否则再遍历");
				//深层递归不再探究
			}
		}
		else {
			//是文件则复制，已有，不再重复
			System.out.println("复制文件操作不重做");
		}
	}
}
