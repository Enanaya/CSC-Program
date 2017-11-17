package threadP;
//合并线程

public class JoinDemo extends Thread{
	public static void main(String[] args) throws InterruptedException {
		JoinDemo j1=new JoinDemo();
		Thread t1=new Thread(j1);//新生
//		new Thread(j1).start();
		t1.start();//就绪
		//cpu调度运行
		
		for (int i = 0; i < 1000; i++) {
			if (i==50) {
				t1.join();//main阻塞
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

