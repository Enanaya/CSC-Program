package chainOfResponsibility;

/**
 * @author 76500
 * ����
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
			System.out.println("����"+request.getEmpname()+"�ļ٣�����"+request.getReason()+"����"+request.getLeaveDays());
			System.out.println("����: "+this.name);
		}else {
			if (this.nextLeaderl!=null) {
				this.nextLeaderl.handleRequest(request);
			}
		}
	}
	
}
