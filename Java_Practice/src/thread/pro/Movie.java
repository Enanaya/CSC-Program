package thread.pro;
//һ������,�ù�ͬ��Դ
//����������ģʽ���źŵƷ�
public class Movie {

	private String pic;
	//�źŵ�
	//flag-->true �����������������ߵȴ���������ɺ�֪ͨ���ѣ���֮
	private boolean flag=true;
	//����
	public synchronized void play(String pic) {
		if (!flag) {//�ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ģ�������ķ�ʱ��
		System.out.println("������"+pic);
		//�������
		//֪ͨ����
		this.notify();
		this.pic=pic;
		this.flag=false;
	}
	
	public synchronized void watch() {
		if (flag) {//�ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ģ�����Ѻķ�ʱ��
		System.out.println("������"+pic);
		//�������
		//֪ͨ����
		this.notify();
		System.out.println(pic);
		this.flag=true;
	}
}
