package 单例模式;

import java.util.concurrent.CountDownLatch;

/**
 * @author 76500 测试单例模式效率
 */
public class Client2 {
	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		int threadnumber = 10;
		final CountDownLatch cdl = new CountDownLatch(threadnumber);

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 1000; i++) {
						Object o = SingletonDemo01.getInstance();
					}
					cdl.countDown();
				}
			}).start();
		}
		cdl.await(); //main线程阻塞，直到计数器变为0，才会继续往下

		long end = System.currentTimeMillis();
		System.out.println( (end - start));
	}
}
