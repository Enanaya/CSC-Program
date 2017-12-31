package 一四到一五;

import java.util.ArrayList;
import java.util.Date;

public class client {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();

		Permanent p1 = new Permanent(new Date(124124), "a", "sdgf", "sdg", "Zoology", 1234, 125.5);
		Permanent p2 = new Permanent(new Date(124124), "b", "sdgf", "sdg", "Zoolog", 1234, 325);
		Permanent p3 = new Permanent(new Date(124124), "c", "sdgf", "sdg", "Zoology", 1234, 500);
		Permanent p4 = new Permanent(new Date(124124), "d", "sdgf", "sdg", "Zoolog", 1234, 65);
		FixerTerm p5 = new FixerTerm(235, "e", "sdgf", "sdg", "Zoolog", 1234, 65);
		employees.add(p1);
		employees.add(p2);
		employees.add(p3);
		employees.add(p4);
		employees.add(p5);
		z(employees);
	}

	// z方法，类型判断需理解
	public static void z(ArrayList<Employee> employees) {
		double total_salary = 0;
		for (Employee employee : employees) {
			if (employee.getDepartment().equals("Zoology") && (employee instanceof Permanent)) {
				System.out.println(employee.getName());
				total_salary += employee.getSalaryl();
			}
		}
		System.out.println(total_salary);
	}
}
