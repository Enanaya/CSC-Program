package threadP;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
//ʹ��callable
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//�����߳�
		ExecutorService service=Executors.newFixedThreadPool(1);
		Race rabbit=new Race(500,"����");
		Race tortoise=new Race(1000,"�ڹ�");
		Future<Integer> res=service.submit(tortoise);
		Future<Integer> res2=service.submit(rabbit);
		
		Thread.sleep(1000);
		rabbit.setFlag(false);
		tortoise.setFlag(false);
		int num=res.get();
		int num2=res2.get();
		System.out.println("�ڹ�����-->"+num);
		System.out.println("��������-->"+num);
		//ֹͣ�߳�
		service.shutdown();
	}
}


class Race implements Callable<Integer>{

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	private String name;
	private int time;//��ʱʱ��
	private boolean flag=true;
	private int step=0;//����
	public Race(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public Race(int time,String name) {
		// TODO Auto-generated constructor stub
		this.time=time;
		this.name=name;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		while (flag) {
			Thread.sleep(time);
			step++;
			
		}
		return step;
		
	}
	
}