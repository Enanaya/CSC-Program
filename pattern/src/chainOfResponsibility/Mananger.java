package chainOfResponsibility;

/**
 * @author 76500
 * 经理
 */
public class Mananger extends Leader{

	public Mananger(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		// TODO Auto-generated method stub
		if (request.getLeaveDays()<10) {
			System.out.println("批了"+request.getEmpname()+"的假，理由"+request.getReason()+"天数"+request.getLeaveDays());
			System.out.println("经理: "+this.name);
		}else {
			if (this.nextLeaderl!=null) {
				this.nextLeaderl.handleRequest(request);
			}
		}
	}
	
}
