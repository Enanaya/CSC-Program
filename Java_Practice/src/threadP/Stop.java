package threadP;

public class Stop {
	public static void main(String[] args) {
		Study study=new Study();
		new Thread(study).start();
		
		//�ⲿ����
		for (int i = 0; i < 100; i++) {
			if (i==50) {
				study.stop();
			}
			System.out.println("main...."+i);
		}
	}
}

class Study implements Runnable{
	//�߳����� �����߳���ʹ�õı�ʶ
	private boolean flag=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//ʹ�øñ�ʶ
		while (flag) {
			System.out.println("study is thread");
		}
	}
	
	//�����ṩ�����ı��ʶ
	public void stop() {
		this.flag=false;
	}
}
