package Ò»Áùµ½Ò»Æß;

public class Per extends Worker{

	public Per(double salaryRate) {
		super(salaryRate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double ComputePay(int hours) {
		// TODO Auto-generated method stub
		return hours*getSalaryRate();
	}
	
}
