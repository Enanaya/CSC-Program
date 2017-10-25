package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import method.Example;
import method.mymethod;

public class Club {
	
	Map<String,Climber> map=new HashMap<String,Climber>(); //keyÎªclimberµÄname
	ArrayList<CM_info> cm_infos=Example.getCM_infos();
	ArrayList<Climber> climbers=new ArrayList<Climber>();
	
	public void setClimbers(ArrayList<Climber> climbers) {
		Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			climbers.add(map.get(iterator.next()));
//			iterator=(Iterator) iterator.next();
		}
	}

	public Club() {
		// TODO Auto-generated constructor stub
		map=mymethod.setCM_info(cm_infos);
		setClimbers(climbers); 
	}
	
	public Map<String, Climber> getMap() {
		return map;
	}
	
	public ArrayList<Climber> getClimbers() {
		return climbers;
	}
	
	/** foreach all climbers to find the max average using average method in class climber 
	 * @return (int) Max_average
	 */
	public Climber Max_average() {
		Climber max=new Climber();
		int max_average=0;
		for (String key : map.keySet()) {
			if (max_average<map.get(key).average()) {
				max_average=map.get(key).average();
				max=map.get(key);
			}
		}
		return max;
	}
	
	
	/**foreach all climbers to find the max height using gethighest method in class climber 
	 * @return CM_info who has max height
	 */
	public CM_info getHighset()  {
		CM_info highest_CM=new CM_info();
		int maxHeight=0;
//		for (Climber climber : climbers) {
//			int current_height=climber.highest_record().getCurrent_height();
//			if (current_height>maxHeight) {
//				maxHeight=current_height;
//				highest_CM=climber.highest_record();
//			}
//		}
		for (String key : map.keySet()) {
			int current_height=map.get(key).highest_record().getCurrent_height();
			if (current_height>maxHeight) {
				maxHeight=current_height;
				highest_CM=map.get(key).highest_record();
			}
		}
		return highest_CM;
	}
	
	
	/**foreach all CM_infos to select whose height is higher than input height
	 * @param height 
	 * @return ArrayList<CM_info> height high than input height
	 */
	public ArrayList<CM_info> pointed_height(int height) {
		ArrayList<CM_info> pointed_CM=new ArrayList<CM_info>();
		for (String key : map.keySet()) {
		pointed_CM.addAll(map.get(key).pointed_heightCM(height));
		}
		return pointed_CM;
	}
	
}
