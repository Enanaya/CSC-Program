package chainOfResponsibility;

/**
 * @author 76500
 * 抽象类
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeaderl;//责任链的后继对象
	public Leader(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param nextLeaderl
	 * 设定责任链上后继对象
	 */
	public void setNextLeaderl(Leader nextLeaderl) {
		this.nextLeaderl = nextLeaderl;
	}
	//处理请求的核心业务方法
	public abstract void handleRequest(LeaveRequest request); 
		
	
}
