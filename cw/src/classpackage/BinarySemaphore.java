package classpackage;

public class BinarySemaphore extends Semaphore {
	public BinarySemaphore(int initial) {
		// TODO Auto-generated constructor stub
		value=(initial >= 1 ? 1 : 0);
	}
	
}
