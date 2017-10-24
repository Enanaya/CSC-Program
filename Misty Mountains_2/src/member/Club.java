package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import method.mymethod;

public class Club {
	
	Map<String, Climber> map=new HashMap<String,Climber>(); //keyÎªclimberµÄname
	ArrayList<CM_info> cm_infos;
	ArrayList<Climber> climbers=new ArrayList<Climber>();
	
	public Club() {
		// TODO Auto-generated constructor stub
		map=mymethod.setCM_info(cm_infos);
		Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			climbers.add((Climber)iterator.next());
		}
	}
	
	public ArrayList<Climber> getClimbers() {
		return climbers;
	}
	
	public int Max_average() {
		int max_average=0;
		for (Climber climber : climbers) {
			if (climber.average()>max_average) {
				max_average=climber.average();
			}
		}
		return max_average;
	}
	
	
	public CM_info getHighset()  {
		CM_info highest_CM=new CM_info();
		int maxHeight=0;
		for (Climber climber : climbers) {
			int current_height=climber.highest_record().getCurrent_height();
			if (current_height>maxHeight) {
				maxHeight=current_height;
				highest_CM=climber.highest_record();
			}
		}
		
		return highest_CM;
	}
	
	
	
}
