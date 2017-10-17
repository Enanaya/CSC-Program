package member;

import java.util.ArrayList;

public class Club {

	private ArrayList<Climber> climbers;
	private Mountain highest_mountain;
	private ArrayList<Mountain> pointed_mountains;
	public ArrayList<Climber> getClimbers() {
		return climbers;
	}
	public void setClimbers(ArrayList<Climber> climbers) {
		this.climbers = climbers;
	}
	public Mountain getHighest_mountain() {
		return highest_mountain;
	}
	public void setHighest_mountain(Mountain highest_mountain) {
		this.highest_mountain = highest_mountain;
	}
	public ArrayList<Mountain> getPointed_mountains() {
		return pointed_mountains;
	}
	public void setPointed_mountains(ArrayList<Mountain> pointed_mountains) {
		this.pointed_mountains = pointed_mountains;
	}
	
	
	
}
