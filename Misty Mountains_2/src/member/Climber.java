package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Climber {
	String C_name;
	String gender;
	int age;
	ArrayList<CM_info> cm_infos;

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

	public CM_info highest_record(ArrayList<CM_info> cm_infos) {
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

	public int average(ArrayList<CM_info> cm_infos) {
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

	public ArrayList<CM_info> pointed_heightCM(ArrayList<CM_info> cm_infos,int point_height) {
		ArrayList<CM_info> pointed_CMinfo=new ArrayList<CM_info>();
		for (CM_info cm_info : cm_infos) {
			if (cm_info.getCurrent_height()>=point_height) {
				pointed_CMinfo.add(cm_info);
			}
		}
		return pointed_CMinfo;
	}
}
