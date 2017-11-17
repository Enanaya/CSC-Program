package ioP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 76500
 *
 */
public class IOstreamDemo {

	public static void main(String[] args) {
		
		//test01();
		//test02();
		test03();
	}
	
	/**
	 *读取文件 
	 */
	public static void test01() {
		String path="E:/iotest/test.txt";
		File src=new File(path);
		InputStream is=null; //提升作用域
		try {
			is=new FileInputStream(src);
			byte[] car=new byte[1024];
			int len=0; //实际读取大小
			//循环读取
			try {
				while (-1!=(len=is.read(car))) { //read没有读取时返回-1
					//输出，将字节数组转字符串
					String info=new String(car,0,len);
					System.out.println(info);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("文件不存在");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 写入文件
	 */
	public static void test02() {
		String path="E:/iotest/test.txt";
		File src=new File(path);
		 //提升作用域
		OutputStream os=null;
		
		try {
			os=new FileOutputStream(src,true);
			String car="12\r334 234\n54";
			byte[] info= car.getBytes();
			int len=info.length;
			os.write(info, 0, len);
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (null!=os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 拷贝
	 */
	public static void test03() {
		//建立联系源（存在且为文件）+目的地（文件可以不存在）
		String path1="E:/iotest/test.txt";
		File src1=new File(path1);
		String path2="E:/iotest/test_c.txt";
		File src2=new File(path2);
		InputStream is=null;
		OutputStream os=null;
		try {
//			boolean flag=src2.createNewFile();
//			System.out.println(flag);
			is=new FileInputStream(src1);
			os=new FileOutputStream(src2);
			
			byte[] str=new byte[1024];
			int len=0;
			while (-1!=(len=is.read(str))) {
//				String writeStr=new String(str);
				os.write(str, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
