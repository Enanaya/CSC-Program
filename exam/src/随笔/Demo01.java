package Ëæ±Ê;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {
	public static void main(String[] args) {
//		Map<String, Integer> map=new HashMap<String, Integer>();
//		map.put("a", 1);
//		map.put("b", 3);
//		map.put("c", 2);
//		map.forEach((k,v)->System.out.println(v));
//		for (String string : map.keySet()) {
//			if (string.equals("b")) {
//				map.remove(string);
//			}
//		}
//		map.forEach((k,v)->System.out.println(v));
		
//		ArrayList<String> list=new ArrayList<String>()  ;
//		list.add("a");
//		String[] strings=list.toArray(new String[list.size()]);
//		System.out.println(strings[0]);
		
		
		
		try {
			System.out.println("start");
			throw new Exception("1");
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("wrong");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("temp");
		}finally {
			System.out.println("end");
		}
	}
	
	
}
