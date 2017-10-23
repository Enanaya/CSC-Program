package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import method.mymethod;

public class Club {
	
	Map<String, Climber> map=new HashMap<String,Climber>(); //keyÎªclimberµÄname
	ArrayList<CM_info> cm_infos;
	
	public Club() {
		// TODO Auto-generated constructor stub
		map=mymethod.setCM_info(cm_infos);
	}
	
}
