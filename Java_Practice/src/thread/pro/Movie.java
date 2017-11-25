package thread.pro;
//一个场景,用共同资源
//生产者消费模式：信号灯法
public class Movie {

	private String pic;
	//信号灯
	//flag-->true 生产者生产，消费者等待，生产完成后通知消费，反之
	private boolean flag=true;
	//播放
	public synchronized void play(String pic) {
		if (!flag) {//等待
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
		}//模拟生产耗费时间
		System.out.println("生产了"+pic);
		//生产完毕
		//通知消费
		this.notify();
		this.pic=pic;
		this.flag=false;
	}
	
	public synchronized void watch() {
		if (flag) {//等待
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
		}//模拟消费耗费时间
		System.out.println("消费了"+pic);
		//消费完毕
		//通知生产
		this.notify();
		System.out.println(pic);
		this.flag=true;
	}
}
