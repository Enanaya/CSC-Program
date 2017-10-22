package member;

import java.util.ArrayList;

public class Club {

	private ArrayList<Climber> climbers;
	private Mountain highest_mountain;
	private ArrayList<Climber_Mountain> cm=new ArrayList<Climber_Mountain>();

	private String name;
	// ArrayList<Climber_Mountain> pointed_mountains;

	public ArrayList<Climber> getClimbers() {
		return climbers;
	}

	public void setClimbers(ArrayList<Climber> climbers) {
		this.climbers = climbers;
	}

	public ArrayList<Climber_Mountain> getCm() {
		return cm;
	}

	public void setCm(ArrayList<Climber> climbers) {
		for (Climber climber : climbers) {
			cm.addAll(climber.getClimbing_info());
		}
	}

	public Club(String name) {
		this.name = name;
	}

	/**
	 * @param climbers all climbers
	 * @return  climber who has highest_average
	 */
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

	Climber_Mountain highest_cm;

	/**
	 * find the highest-cm
	 */
	public void getHighest_mountain() {
		int max = 0;
		for (Climber climber : climbers) {
			if (climber.gethighset().getCurrent_height() > max) {
				highest_cm = climber.gethighset();
			}
		}
	}

	
	/**
	 * input pointed_height to get cm-list which have height more pointed_height
	 * @param pointed_height
	 * @return cm-list
	 */
	public ArrayList<Climber_Mountain> getPointed_mountains(int pointed_height) {

		ArrayList<Climber_Mountain> pointed_mountains = new ArrayList<Climber_Mountain>();

		for (Climber climber : climbers) {
			for (Climber_Mountain cm : climber.getClimbing_info()) {
				if (cm.getCurrent_height() > pointed_height) {
					pointed_mountains.add(cm);
				}
			}
		}
		// this.pointed_mountains=pointed_mountains;

		return pointed_mountains;
	}

}
