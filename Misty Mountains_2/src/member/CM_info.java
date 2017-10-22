package member;

public class CM_info {

	int ID;
	String C_name;
	String M_name;
	int current_height;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public String getM_name() {
		return M_name;
	}

	public void setM_name(String m_name) {
		M_name = m_name;
	}

	public int getCurrent_height() {
		return current_height;
	}

	public void setCurrent_height(int current_height) {
		this.current_height = current_height;
	}

	public CM_info(int iD, String c_name, String m_name, int current_height) {
		super();
		ID = iD;
		C_name = c_name;
		M_name = m_name;
		this.current_height = current_height;
	}
	
	public CM_info(String c_name, String m_name, int current_height) {
		super();
		C_name = c_name;
		M_name = m_name;
		this.current_height = current_height;
	}
	
}
