package classpackage;


public class Client {
	public static void main(String[] args) throws InterruptedException  {
		BinarySemaphore a=new BinarySemaphore(1);
		BinarySemaphore b=new BinarySemaphore(0);
		Thread t1=new ThreadX(a,b);
		Thread t2=new ThreadY(a,b);
		Thread t3=new ThreadZ();
		t1.start();
		t2.start();
		t3.start();
	}
}
