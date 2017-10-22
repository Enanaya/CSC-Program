package member;

import java.util.ArrayList;

public class Climber {

	private int age;
	private String gender;
	private ArrayList<Mountain> Mountains;
	//private int id=1;
	private String name;
	
	private ArrayList<Climber_Mountain> climbing_info=new ArrayList<Climber_Mountain>();
	
 	public ArrayList<Climber_Mountain> getClimbing_info() {
		return climbing_info;
	}

//	public int getId() { 
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ArrayList<Mountain> getMountains() {
		return Mountains;
	}
	public void setMountains(ArrayList<Mountain> mountains) {
		this.Mountains = mountains;
	}
	
	public Climber(String name, int age, String gender ) {
//		super();
		setName(name);
		setAge(age);
		setGender(gender);
	}
	
	/**
	 *load cm_info while begin the process
	 * @param cm-list(climber_mountain)
	 */
	public void create_cm(ArrayList<Climber_Mountain> cm) {
		for (Climber_Mountain climber_mountain : cm) {
			if (climber_mountain.getClimber_name()==this.name) {
				climbing_info.add(climber_mountain);
			}
		}
	}
	
	/**
	 * update info after add record every time
	 * @param cm-climber_mountain
	 */
	public void update_cm(Climber_Mountain cm) {
			climbing_info.add(cm);
	}
	
	/**
	 * @return cm-info which have highest record
	 */
	public Climber_Mountain gethighset() {
		
		int max_index=0;int top_height=0;
		
		for (int i = 0; i < climbing_info.size(); i++) {
			if (climbing_info.get(i).getCurrent_height()>top_height) {
				top_height=climbing_info.get(i).getCurrent_height();
				max_index=i;
			}
		}
		
		return climbing_info.get(max_index);
	}

	
	/**
	 * @return climber's average height
	 */
	public int average() {
		int total = 0;
		if (climbing_info.size()==0) {
			return 0;
		}
		for (Climber_Mountain info : climbing_info) {
			total+=info.getCurrent_height();
		}
		return total/climbing_info.size();
	}

	
	/**
	 * input pointed_height to get cm-list which have height more pointed_height
	 * @param pointed_height
	 * @return cm-list
	 */
	public ArrayList<Climber_Mountain> pointed_mountains(int pointed_height) {
	
		ArrayList<Climber_Mountain> pointed_mountains=new ArrayList<Climber_Mountain>();
		
		for (Climber_Mountain info : climbing_info) {
			if (info.getCurrent_height()>pointed_height) {
				pointed_mountains.add(info);
			}
		}
		return pointed_mountains;
	}
	
	public Climber() {
		// TODO Auto-generated constructor stub
	}
}
