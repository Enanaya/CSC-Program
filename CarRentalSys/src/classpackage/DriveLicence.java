package classpackage;

import java.util.Date;

public class DriveLicence {

	private Name name;
	private Date birthday;
	private LicenceNum ln;
	private Date issueDate; // 发证日期
	private boolean isFull; // 是否完整

	public DriveLicence() {
	}

	public DriveLicence(Person p, Date birth,  Date issueDate) {
		this.name = p.getName();
		this.birthday = birth;
		this.issueDate = issueDate;
		this.ln = new LicenceNum(p,issueDate);

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
