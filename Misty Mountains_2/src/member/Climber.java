package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 	store data about individuals info and list of own CM_info  
 *  have methods to set/add CM_info,get average height or pointedheight from own CM_info
 */
public class Climber {
	String C_name;
	String gender;
	int age;
	ArrayList<CM_info> cm_infos=new ArrayList<CM_info>();
	
	
	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<CM_info> getCm_infos() {
		return cm_infos;
	}

	public void setCm_infos(ArrayList<CM_info> cm_infos) {
		this.cm_infos = cm_infos;
	}

	public void addCm_infos(CM_info cm_info) {
		this.cm_infos.add(cm_info);
	}

	// Map< String, CM_info> map=new HashMap<String,CM_info>();

	public Climber() {
		// TODO Auto-generated constructor stub
		cm_infos = new ArrayList<CM_info>();
	}

	public Climber(String C_name) {
		// TODO Auto-generated constructor stub
		this();
		this.C_name = C_name;
	}

	public Climber(String c_name, String gender, int age, ArrayList<CM_info> cm_infos) {
		C_name = c_name;
		this.gender = gender;
		this.age = age;
		this.cm_infos = cm_infos;
	}

	public Climber(String c_name, String gender, int age) {
		super();
		C_name = c_name;
		this.gender = gender;
		this.age = age;
	}

	/**method to find the highest height among CM_infos in this climber
	 * @return CM_info with highest height record
	 */
	public CM_info highest_record() {
		CM_info highest = new CM_info();
		int max = 0;
		for (CM_info cm_info : cm_infos) {
			if (cm_info.getCurrent_height() > max) {
				max = cm_info.getCurrent_height();
				highest = cm_info;
			}
		}
		return highest;
	}

	/**method to get average height from all CM_info in this climber
	 * @return (int)average height
	 */
	public int average() {
		if (cm_infos.size() == 0) {
			return 0;
		} else {
			int total = 0;
			for (CM_info cm_info : cm_infos) {
				total += cm_info.getCurrent_height();
			}
			return total / cm_infos.size();
		}
	}

	/**
	 * input pointed_height to select the CM_info whose height is higher than pointed_height
	 * @param point_height get from keyboard input
	 * @return  return CM_infos whose height is higher than pointed_height
	 */
	public ArrayList<CM_info> pointed_heightCM(int point_height) {
		ArrayList<CM_info> pointed_CMinfo=new ArrayList<CM_info>();
		for (CM_info cm_info : cm_infos) {
			if (cm_info.getCurrent_height()>=point_height) {
				pointed_CMinfo.add(cm_info);
			}
		}
		return pointed_CMinfo;
	}
}
