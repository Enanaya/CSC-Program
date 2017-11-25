package threadP;
//合并线程
//自我理解，join多用在main，代表main让出资源让其他线程执行，比如t1.join，main等待t1执行完毕;t1为抢资源主体
//如果是join(int)，则代表等待线程执行int时间

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

