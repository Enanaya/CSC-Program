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
		
//		test01();
		test02();
	}
	
	public static void test01() {
		
		File src=new File("E:\\iotest\\test_c.txt");
		
		Reader reader=null;
		try {
			reader=new FileReader(src);
			char[] flush=new char[1024];
			int len=0;
			while (-1!=(len=reader.read(flush))) {
				//×Ö·ûÊý×é×ª×Ö·û´®
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
			String msg="asd\r\nretÍÛÉª";
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

