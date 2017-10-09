package filetest;

import java.io.File;

public class TestFileTree {// please try to change the structure into Horizontal binary tree
	public static void main(String[] args) {
		
		File f1=new File("E:/filedir1");
		printFile(f1,0);
	}

	static void printFile(File file,int level) {
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files=file.listFiles();
			for(File temp:files) {
				printFile(temp,level+1);
			}
			//System.out.println();

		}
	}
}