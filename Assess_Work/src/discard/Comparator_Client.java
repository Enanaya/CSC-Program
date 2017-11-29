package discard;

import java.util.Comparator;

public class Comparator_Client implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		String[] str1 = o1.split(" ");
		String[] str2 = o2.split(" ");
		int res = str1[1].substring(0, 1).compareTo(str2[1].substring(0, 1));
		if (res==0) {
			res=str1[0].substring(0, 1).compareTo(str2[0].substring(0, 1));
		}
		
		return res;
	}

}
