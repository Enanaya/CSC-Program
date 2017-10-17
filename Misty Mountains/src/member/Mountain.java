package member;

public class Mountain {

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {

		this.height = height;
	}

	
	public Mountain(String name,int height) {
//		super();
		setName(name);
		setHeight(height);
	}
	
	public Mountain() {
		// TODO Auto-generated constructor stub
	}

    
}
