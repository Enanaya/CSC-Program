package Comparator_P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Demo {

	public static void main(String[] args) {
		ArrayList<Comparator_Test> CTlist = new ArrayList<Comparator_Test>();
		
		Comparator_Test CT1=new Comparator_Test();
		CT1.age=5;
		CTlist.add(CT1);
		Comparator_Test CT2 = new Comparator_Test();
		CT2.age=8;
		CTlist.add(CT2);
		Comparator_Test CT3 = new Comparator_Test();
		CT3.age=2;
		CTlist.add(CT3);
		Collections.sort(CTlist);
		for (Comparator_Test comparator_Test : CTlist) {
			System.out.println(comparator_Test.age);
		}
	}
}
