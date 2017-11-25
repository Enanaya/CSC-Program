package threadP;

//过多同步方法可能造成死锁

public class SynDemo03 {

	public static void main(String[] args) {
		
		Object g=new Object();
		Object m = new Object();
		Test test1 = new Test(g, m);
		Thread t1=new Thread(test1);
		t1.start();
		Test2 test2=new Test2(g, m);
		Thread t2=new Thread(test2);
		t2.start();
	}
}

class Test implements Runnable {
	Object goods ;
	Object money ;

	public Test(Object goods,Object money) {
		// TODO Auto-generated constructor stub
		this.goods=goods;
		this.money=money;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			test();
		}
	}

	public void test() {
		synchronized (goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (money) {
				
			}
			
		}
		System.out.println("一手给钱");
	}

}


class Test2 implements Runnable {
	Object goods ;
	Object money ;

	public Test2(Object goods,Object money) {
		// TODO Auto-generated constructor stub
		this.goods=goods;
		this.money=money;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			test();
		}
	}

	public void test() {
		synchronized (money) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (goods) {
				
			}
			
		}
		System.out.println("一手给货");
	}

}