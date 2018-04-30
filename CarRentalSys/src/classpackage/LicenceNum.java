package classpackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

<<<<<<< HEAD
/**
 * a class to serve as licence number in drivelicence
 * extends individual info to create licence number
 * @author Z.Liang
 *
 */
public class LicenceNum extends DriveLicence {
=======
public class LicenceNum  extends DriveLicence{
>>>>>>> parent of 770471f... 基本完成

	private String name;
	private String issueDate;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	private int serial;
	private String ln;
	private static final ArrayList<String> lns=new ArrayList<String>();

	public LicenceNum(Person p,  Date issueDate) {
		this.name += p.getName().getFirstName().charAt(0);
		this.name += p.getName().getLastName().charAt(0);
		this.issueDate = sdf.format(issueDate);
		serial = new Random().nextInt(90) + 10;
		ln=name + "-" + issueDate + "-" +serial;
	}
	
	public static String getInstance(Person p,  Date issueDate) {
		String temp;
		while (!lns.contains(temp=lnGenerate(p, issueDate))) {
			return temp;
		}
		return null;
	}
	
	private static String lnGenerate(Person p,  Date issueDate) {
		return p.getName().getFirstName().charAt(0)+p.getName().getLastName().charAt(0)
				+sdf.format(issueDate)+(new Random().nextInt(90) + 10);
	}
	
	public String toString() {
		return ln;
	}
	
}
