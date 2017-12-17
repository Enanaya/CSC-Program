package testCompile;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) {
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int res=compiler.run(null, null, null, "E:/compileTest/HW.java");
		System.out.println(res);
	}
}
