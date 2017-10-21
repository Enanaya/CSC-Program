package method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import listMethod.Mylist;
import member.Climber;
import member.Climber_Mountain;

public class method {

	public void printeduser(ArrayList<Climber> climbers) {
		for (Climber climber : climbers) {
			System.out.println(climber.getName());
		}
	}

	public static Climber_Mountain addRecord(int id, String Climber_name, 
			String Mountain_name, int height) {
		return new Climber_Mountain(id, Climber_name, Mountain_name, height);
	}
	
	public  static ArrayList distinct(ArrayList mylist) {
		Set set = new HashSet();
		ArrayList newList = new ArrayList();
		for (Iterator iter = mylist.iterator(); iter.hasNext();) {
			Object element =  iter.next();
			if (set.add(element))
				newList.add(element);
		}
		mylist.clear();
		mylist.addAll(newList);
		return mylist;
	}
	
}
