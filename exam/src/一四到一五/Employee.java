package 一四到一五;

import java.util.ArrayList;
import java.util.Date;

public class Employee {

	private String name, address, designation, department;
	private int personnel_number;
	private double salary;

	public Employee(String name, String address, String designation, String department, int personnel_number,
			double salary) {
		super();
		this.name = name;
		this.address = address;
		this.designation = designation;
		this.department = department;
		this.personnel_number = personnel_number;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPersonnel_number() {
		return personnel_number;
	}

	public void setPersonnel_number(int personnel_number) {
		this.personnel_number = personnel_number;
	}

	public double getSalaryl() {
		return salary;
	}

	public void setSalaryl(double salaryl) {
		this.salary = salaryl;
	}

}

class Permanent extends Employee {
	private Date starting_date;

	public Date getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}

	public Permanent(Date date, String name, String address, String designation, String department,
			int personnel_number, double salary) {
		super(name, address, designation, department, personnel_number, salary);
		this.starting_date = date;
	}

}

class FixerTerm extends Employee {
	private int duration;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public FixerTerm(int duration, String name, String address, String designation, String department,
			int personnel_number, double salary) {
		super(name, address, designation, department, personnel_number, salary);
		this.duration = duration;
	}

}
