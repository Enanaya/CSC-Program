package threadP;
//�ϲ��߳�

public class JoinDemo extends Thread{
	public static void main(String[] args) throws InterruptedException {
		JoinDemo j1=new JoinDemo();
		Thread t1=new Thread(j1);//����
//		new Thread(j1).start();
		t1.start();//����
		//cpu��������
		
		for (int i = 0; i < 1000; i++) {
			if (i==50) {
				t1.join();//main����
			}
			System.out.println("main...."+i);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		for (int i = 0; i < 1000; i++) {
			System.out.println("join...."+i);
		}
	}
	
	
}

