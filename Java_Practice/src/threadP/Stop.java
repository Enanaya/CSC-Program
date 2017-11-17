package threadP;

public class Stop {
	public static void main(String[] args) {
		Study study=new Study();
		new Thread(study).start();
		
		//外部干涉
		for (int i = 0; i < 100; i++) {
			if (i==50) {
				study.stop();
			}
			System.out.println("main...."+i);
		}
	}
}

class Study implements Runnable{
	//线程类中 定义线程体使用的标识
	private boolean flag=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//使用该标识
		while (flag) {
			System.out.println("study is thread");
		}
	}
	
	//对外提供方法改变标识
	public void stop() {
		this.flag=false;
	}
}
