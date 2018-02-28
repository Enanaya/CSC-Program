package Ò»Áùµ½Ò»Æß;

public class Worker {
	private double salaryRate;
	private static int WEEKLY_HOUR=40;
	public double getSalaryRate() {
		return salaryRate;
	}
	public void setSalaryRate(double salaryRate) {
		this.salaryRate = salaryRate;
	}
	public static int getWEEKLY_HOUR() {
		return WEEKLY_HOUR;
	}
	public static void setWEEKLY_HOUR(int wEEKLY_HOUR) {
		WEEKLY_HOUR = wEEKLY_HOUR;
	}
	public Worker(double salaryRate) {
		super();
		this.salaryRate = salaryRate;
	}
	
	public double ComputePay(int hours) {
		return salaryRate*hours;
	}
}
