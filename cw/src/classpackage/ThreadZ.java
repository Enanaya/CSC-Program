package classpackage;

public class ThreadZ extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep((long) (Math.random()*1000));
				System.out.print("Z");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
