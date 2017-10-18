package method;

import java.util.ArrayList;

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
}
