package ����ģʽ;

import java.util.concurrent.CountDownLatch;

/**
 * @author 76500 ���Ե���ģʽЧ��
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
		cdl.await(); //main�߳�������ֱ����������Ϊ0���Ż��������

		long end = System.currentTimeMillis();
		System.out.println( (end - start));
	}
}
