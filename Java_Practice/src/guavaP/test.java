package guavaP;

import java.util.List;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;

public class test {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		List<String> readlist=Collections.unmodifiableList(list);
		List<String> theseElements = Lists.newArrayList("alpha", "beta", "gamma");

		theseElements.forEach(n->System.out.println());
	}
	
		
}
