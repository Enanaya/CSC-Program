package method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import member.CM_info;
import member.Climber;

public class mymethod {

	public static Map<String, Climber> setCM_info(ArrayList<CM_info> cm_infos) {
		Map<String, Climber> map=new HashMap<String,Climber>();
		for (CM_info cm_info : cm_infos) {
			String c_name=cm_info.getC_name();
//			if (c_name==C_name) {
			Climber climber=map.get(c_name);
				if (climber == null) {
					climber=new Climber(c_name); //应完善通过cm创建新climber的方法
					map.put(c_name, climber);
				}
//			}
				climber.addCm_infos(cm_info);
		}
		return map;
	}
}
