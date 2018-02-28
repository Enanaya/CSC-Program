package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface CallBack {
	public ArrayList<Object> doExecute(Connection conn,PreparedStatement ps,ResultSet rs) ;
	
}
