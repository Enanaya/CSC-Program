package Comparator_P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_P2 {
	 private String name;
	    private Integer age;
	    private float score;

	    public Comparator_P2(String name, Integer age, float score) {
	        super();
	        this.name = name;
	        this.age = age;
	        this.score = score;
	    }

	    @Override
	    public String toString() {
	        return "name:" + name + ";age:" + age + ";score:" + score;
	    }


	    @SuppressWarnings({ "rawtypes", "unchecked" })
	    public static void main(String[] args) {
	        List<Comparator_P2> lists = new ArrayList<>();
	        lists.add(new Comparator_P2("a", 4, 4));
	        lists.add(new Comparator_P2("b", 3, 6));
	        lists.add(new Comparator_P2("c", 2, 3));
	        lists.add(new Comparator_P2("d", 1, 7));
	        Comparator c = new ComparatorList();
	        Collections.sort(lists, c);
	        for (Comparator_P2 comparatorDemo : lists) {
	            System.out.println("++++++" + comparatorDemo);
	        }
	        
	        Comparator_P2 com[] = {new Comparator_P2("a", 4, 4),
	                new Comparator_P2("b", 3, 6),
	                new Comparator_P2("c", 2, 3),
	                new Comparator_P2("d", 1, 7)};
	        Arrays.sort(com, c);
	        for (Comparator_P2 comparatorDemo : com) {
	            System.out.println("------" + comparatorDemo);
	        }
	    }
	    
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }

	    public float getScore() {
	        return score;
	    }

	    public void setScore(float score) {
	        this.score = score;
	    }

}



 class ComparatorList  implements Comparator<Comparator_P2>{
    //我们也可以通过构造方法注入一些参数加入到比较中
    
    @Override
    public int compare(Comparator_P2 o1, Comparator_P2 o2) {
        if (o1.getScore() > o2.getScore())
            return -1;// 由高到底排序
        else if (o1.getScore() < o2.getScore())
            return 1;
        else {
            if (o1.getAge() > o2.getScore())
                return 1;// 由底到高排序
            else if (o1.getAge() < o2.getAge())
                return -1;
            else
                return 0;
        }
    }
}
