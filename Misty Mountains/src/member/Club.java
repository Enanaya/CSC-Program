package member;

import java.util.ArrayList;

public class Club {

	private ArrayList<Climber> climbers;
	private Mountain highest_mountain;
	private String name;
//	ArrayList<Climber_Mountain> pointed_mountains;

	public ArrayList<Climber> getClimbers() {
		return climbers;
	}

	public void setClimbers(ArrayList<Climber> climbers) {
		this.climbers = climbers;
	}

	public Club(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	
	public Climber highest_average(ArrayList<Climber> climbers) {
		int top_height = 0;
		int index = 0, temp = 0;
		for (Climber climber : climbers) {
			temp++;
			if (climber.average() > top_height) {
				top_height = climber.average();
				index = temp;
			}
		}
		return climbers.get(index);
	}

	public void getHighest_mountain() {
		
		
	}

	public ArrayList<Climber_Mountain> getPointed_mountains(int pointed_height) {
		
		ArrayList<Climber_Mountain> pointed_mountains =new ArrayList<Climber_Mountain>();
		
		for (Climber climber : climbers) {
			for (Climber_Mountain cm : climber.getClimbing_info()) {
				if (cm.getCurrent_height() > pointed_height) {
					pointed_mountains.add(cm);
				}
			}
		}
//		this.pointed_mountains=pointed_mountains;
		
		return pointed_mountains;
	}

}
