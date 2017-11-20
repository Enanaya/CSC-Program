package ioP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class IO_char {
	public static void main(String[] args) {
		
		IO_char io=new IO_char();
		io.currentDir();
//		test01();
		//test02();
	}
	
	public void currentDir() {//获取当前工作目录的bin
		File f = new File(this.getClass().getResource("/").getPath()); 
		//System.getProperty("user.dir")+"/src/ 获取当前src下目录
		System.out.println(f);
	}
	
	
	public static void test01() {
		
		File src=new File("E:\\iotest\\test_c.txt");
		
		Reader reader=null;
		try {
			reader=new FileReader(src);
			char[] flush=new char[1024];
			int len=0;
			while (-1!=(len=reader.read(flush))) {
				//字符数组转字符串
				String string=new String(flush, 0, len);
				System.out.println(string);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void test02() {
		File dest=new File("E:/iotest/char.txt");
		
		Writer wr=null;
		 try {
//			 if (!dest.exists()) {
//				dest.createNewFile();
//			}
			wr=new FileWriter(dest);
			String msg="asd\r\nret哇瑟";
			wr.write(msg);
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			try {
				wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//copy file
	public static void test03() {
		
	}
}

