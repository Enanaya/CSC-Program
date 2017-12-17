package chainOfResponsibility;

public class Director extends Leader{

	public Director(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		// TODO Auto-generated method stub
		if (request.getLeaveDays()<3) {
			System.out.println("����"+request.getEmpname()+"�ļ٣�����"+request.getReason()+"����"+request.getLeaveDays());
			System.out.println("����: "+this.name);
		}else {
			if (this.nextLeaderl!=null) {
				this.nextLeaderl.handleRequest(request);
			}
		}
	}
	
}
