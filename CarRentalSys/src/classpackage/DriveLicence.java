package classpackage;

import java.util.Date;

public class DriveLicence {

	private Name name;
	private Date birthday;
	/**
	 * unique licence number
	 */
	private LicenceNum ln;
	private Date issueDate;
	/**
	 * judge whther this licence is full to drive car
	 */
	private boolean isFull;

	public DriveLicence() {
	}

	public DriveLicence(Person p, Date issueDate) {
		if (p.getName().length() == 0)
			throw new IllegalArgumentException("empty string");
		if (p.getBirthday().getTime() < 0) {
			throw new IllegalArgumentException("invalid birthday");
		}
		this.name = p.getName();
		this.birthday = p.getBirthday();
		this.issueDate = issueDate;
		this.ln = new LicenceNum(p, issueDate);

		if (p != null && birthday != null && ln != null && issueDate != null) {
			isFull = true;
		} else {
			isFull = false;
		}
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public boolean isFull() {
		return isFull;
	}
}
