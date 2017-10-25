package method;

import java.util.ArrayList;

import member.CM_info;
import member.Climber;
import member.Mountain;

public class Example {

	public static ArrayList<CM_info> getCM_infos() {
		ArrayList<CM_info> cm_infos = new ArrayList<CM_info>();

		cm_infos.add(new CM_info(01, "Mike", "A", 1892));
		cm_infos.add(new CM_info(02, "John", "B", 528));
		cm_infos.add(new CM_info(03, "Andy", "C", 999));
		cm_infos.add(new CM_info(04, "Mike", "A", 2001));

		return cm_infos;
	}

	public static ArrayList<Mountain> getMountains() {
		ArrayList<Mountain> mountains = new ArrayList<Mountain>();

		mountains.add(new Mountain("A", 3000));
		mountains.add(new Mountain("B", 2000));
		mountains.add(new Mountain("C", 4000));

		return mountains;
	}

	public static ArrayList<Climber> getClimbers() {
		ArrayList<Climber> climbers = new ArrayList<Climber>();

		climbers.add(new Climber("Mike", "Male", 24));
		climbers.add(new Climber("John", "Male", 16));
		climbers.add(new Climber("Andy", "Female", 30));
		
		return climbers;
	}
}
