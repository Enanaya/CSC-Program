package chainOfResponsibility;

public class Client {
	public static void main(String[] args) {
		Leader a=new Director("����");
		Leader b=new Mananger("����");
		
		//��֯���ζ���Ĺ�ϵ
		a.setNextLeaderl(b);
		
		//��ʼ���
		LeaveRequest lq=new LeaveRequest("����", 5, "����");
		a.handleRequest(lq);
	}
}
