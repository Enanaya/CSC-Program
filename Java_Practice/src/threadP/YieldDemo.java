package threadP;

public class YieldDemo extends Thread{
	public static void main(String[] args) throws InterruptedException {
		YieldDemo j1=new YieldDemo();
		Thread t1=new Thread(j1);//新生
//		new Thread(j1).start();
		t1.start();//就绪
		//cpu调度运行
		
		for (int i = 0; i < 1000; i++) {
			if (i%20==0) {
				Thread.yield();//main暂停,静态方法，写在哪个线程里就暂停哪个，效果不是很明显
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
