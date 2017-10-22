package member;

public class Mountain {
	String M_name;
	int height;
	
	public String getM_name() {
		return M_name;
	}

	public void setM_name(String m_name) {
		M_name = m_name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Mountain(String m_name, int height) {
		super();
		M_name = m_name;
		this.height = height;
	}
	
	public Mountain() {
		// TODO Auto-generated constructor stub
	}
}
