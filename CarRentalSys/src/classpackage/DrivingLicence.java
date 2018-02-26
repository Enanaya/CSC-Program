package classpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DrivingLicence {
	private Date birthday;
	private String firstname;
	private String lastname;

	private String drivingLicence;
	
	private DrivingLicence(Calendar birthday,String firstname,String lastname) {
		// TODO Auto-generated constructor stub
		this.birthday=birthday.getTime();
		this.firstname=firstname;
		this.lastname=lastname;
		drivingLicence=generateDL(this.birthday, firstname, lastname);
		System.out.println(drivingLicence);
	}
	
	private static final String HYPHEN="-";
	
	/** this method will generate a drivingLicence following some rules
	 * @param birthday send Date type and format into data with only year
	 * @param firstname
	 * @param lastname
	 * @return drivingLicence a unique drivingLicence for one person like "MS-1990-79" 
	 */
	private String generateDL(Date birthday,String firstname,String lastname) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		
		StringBuilder dl = new StringBuilder();
		dl.append(firstname.substring(0, 1)).append(lastname.substring(0, 1));
		dl.append(HYPHEN);
		dl.append(sdf.format(birthday)+HYPHEN);
		
		int random=new Random().nextInt(90)+10;
		dl.append(random);
		return dl.toString();
	}
	
	/*public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		DrivingLicence dl=new DrivingLicence(c, "Mark", "Smith");
	}*/
}
