package chainOfResponsibility;

public class Client {
	public static void main(String[] args) {
		Leader a=new Director("张三");
		Leader b=new Mananger("李四");
		
		//组织责任对象的关系
		a.setNextLeaderl(b);
		
		//开始请假
		LeaveRequest lq=new LeaveRequest("王五", 5, "死了");
		a.handleRequest(lq);
	}
}
