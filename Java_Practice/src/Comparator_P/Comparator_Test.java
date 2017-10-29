package Comparator_P;

public class Comparator_Test implements Comparable<Comparator_Test>{

	int age;

	@Override
	public int compareTo(Comparator_Test o) {
		// TODO Auto-generated method stub
		
		return this.age-o.age;
	}
}
