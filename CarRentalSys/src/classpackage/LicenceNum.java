package classpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LicenceNum  extends DriveLicence{

	private String name;
	private String issueDate;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	private int serial;

	public LicenceNum(Person p,  Date issueDate) {
		this.name += p.getName().getFirstName().charAt(0);
		this.name += p.getName().getLastName().charAt(0);
		this.issueDate = sdf.format(issueDate);
		serial = new Random().nextInt(90) + 10;
	}

	public String toString() {
		return name + "-" + issueDate + "-" +serial;
	}
}
