package classpackage;

/**
 * @author 76500
 *  using Producer/Consumer -solution P118
 */
public class ThreadX extends Thread {
	private BinarySemaphore bsempX = null;
	private BinarySemaphore bsempY = null;

	public ThreadX(BinarySemaphore bsempX, BinarySemaphore bsempY) {
		// TODO Auto-generated constructor stub
		this.bsempX = bsempX;
		this.bsempY = bsempY;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				bsempX.P();
				Thread.sleep((long) (Math.random()*1000));
				System.out.print("X");
				bsempY.V();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
