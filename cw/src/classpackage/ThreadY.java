package classpackage;

/**
 * @author 76500
 *  using Producer/Consumer -solution P118
 *  end in this thread
 */
public class ThreadY extends Thread {
	private BinarySemaphore bsempX = null;
	private BinarySemaphore bsempY = null;
	private int count=10;

	public ThreadY(BinarySemaphore bsempX, BinarySemaphore bsempY ) {
		// TODO Auto-generated constructor stub
		this.bsempX = bsempX;
		this.bsempY = bsempY;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				bsempY.P();
				Thread.sleep((long) (Math.random()*1000));
				System.out.print("Y");
				if (count--<0) {
					System.exit(0);
				}
				bsempX.V();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
