package threadP;

public class YieldDemo extends Thread{
	public static void main(String[] args) throws InterruptedException {
		YieldDemo j1=new YieldDemo();
		Thread t1=new Thread(j1);//����
//		new Thread(j1).start();
		t1.start();//����
		//cpu��������
		
		for (int i = 0; i < 1000; i++) {
			if (i%20==0) {
				Thread.yield();//main��ͣ,��̬������д���ĸ��߳������ͣ�ĸ���Ч�����Ǻ�����
			}
			System.out.println("main...."+i);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		for (int i = 0; i < 1000; i++) {
			System.out.println("yield...."+i);
		}
	}
}
