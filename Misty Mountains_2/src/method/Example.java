package method;

import java.util.ArrayList;

import member.CM_info;
import member.Climber;
import member.Mountain;

/**
 * this is a example class to initialize data for a club,using static method.
 *
 */
public class Example {

	/**
	 * @return return CM_info example
	 */
	public static ArrayList<CM_info> getCM_infos() {
		ArrayList<CM_info> cm_infos = new ArrayList<CM_info>();

		cm_infos.add(new CM_info( "Mike", "A", 1892));
		cm_infos.add(new CM_info( "John", "B", 528));
		cm_infos.add(new CM_info( "Andy", "C", 999));
		cm_infos.add(new CM_info( "Mike", "A", 2001));

		return cm_infos;
	}

	/**
	 * @return return Mountains example
	 */
	public static ArrayList<Mountain> getMountains() {
		ArrayList<Mountain> mountains = new ArrayList<Mountain>();

		mountains.add(new Mountain("A", 3000));
		mountains.add(new Mountain("B", 2000));
		mountains.add(new Mountain("C", 4000));

		return mountains;
	}

	/**
	 * @return return Climbers example
	 */
	public static ArrayList<Climber> getClimbers() {
		ArrayList<Climber> climbers = new ArrayList<Climber>();

		climbers.add(new Climber("Mike", "Male", 24));
		climbers.add(new Climber("John", "Male", 16));
		climbers.add(new Climber("Andy", "Female", 30));
		
		return climbers;
	}
}
