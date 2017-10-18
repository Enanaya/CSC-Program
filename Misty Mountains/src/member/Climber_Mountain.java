package member;

public class Climber_Mountain {

	private int Id;
	private String Climber_name;
	private String Mountain_name;
	private int current_height;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getClimber_name() {
		return Climber_name;
	}
	public void setClimber_name(String climber_name) {
		Climber_name = climber_name;
	}
	public String getMountain_name() {
		return Mountain_name;
	}
	public void setMountain_name(String mountain_name) {
		Mountain_name = mountain_name;
	}
	public int getCurrent_height() {
		return current_height;
	}
	public void setCurrent_height(int current_height) {
		this.current_height = current_height;
	}
	public Climber_Mountain(int id, String climber_name, String mountain_name, int current_height) {
		Id = id;
		setClimber_name(climber_name);
		setMountain_name(mountain_name);
		setCurrent_height(current_height);
	}
	
	
}
