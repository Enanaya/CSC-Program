package chainOfResponsibility;

/**
 * @author 76500
 * ������
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeaderl;//�������ĺ�̶���
	public Leader(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param nextLeaderl
	 * �趨�������Ϻ�̶���
	 */
	public void setNextLeaderl(Leader nextLeaderl) {
		this.nextLeaderl = nextLeaderl;
	}
	//��������ĺ���ҵ�񷽷�
	public abstract void handleRequest(LeaveRequest request); 
		
	
}
