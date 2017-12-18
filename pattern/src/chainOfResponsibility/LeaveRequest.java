package chainOfResponsibility;

/**
 * @author 76500
 *	封装请假基本信息
 */
public class LeaveRequest {
	private String empname;
	private int leaveDays;
	private String reason;
	public LeaveRequest(String empname, int leaveDays, String reason) {
		super();
		this.empname = empname;
		this.leaveDays = leaveDays;
		this.reason = reason;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String rea) {
		this.reason = rea;
	}
	
}
