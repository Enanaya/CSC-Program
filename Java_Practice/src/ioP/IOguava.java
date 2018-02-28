package ioP;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.jws.soap.SOAPBinding.Use;

import com.google.common.io.Files;


public class IOguava {

	public static void main(String[] args) {
		
		test01();
	}
	
	public static void test01() {
		File src=new File("E:\\iotest/char.txt");

		File des=new File("E:\\iotest/copy.txt");
		try {
			BufferedReader bf=Files.newReader(src, Charset.defaultCharset());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Files.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
