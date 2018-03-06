package ·ÏÆú;

public class PersonTest {
    private PersonTest() {  }
    
    public static void main(String[] args) {
        final PersonTest tp = new PersonTest();
        
        tp.testPerson();
        
        tp.testGetAge();
        
        tp.testGetName();
        
        tp.testEquals();
    }
              
    // testing the Person constructor
    private void testPerson() {
        final String name = "Nick";
        final int age = 50;
        
        // test normal case
        final Person p = new Person(name, age);
        
        Assertions.assertEquals(name, p.getName());
        Assertions.assertEquals(age, p.getAge());
        
        // test null name
        try {
            final Person nullName = new Person(null, age);
            Assertions.assertNotReached();
        } catch (Throwable t) {
            Assertions.assertExpectedThrowable(
                NullPointerException.class, t);
        }
        
        // test empty name
        try {
            final Person emptyName = new Person("", age);
            Assertions.assertNotReached();
        } catch (Throwable t) {
            Assertions.assertExpectedThrowable(
                IllegalArgumentException.class, t);
        }
        
        // test age range
        final Person maxAge = new Person(name, Integer.MAX_VALUE);
        
        Assertions.assertEquals(Integer.MAX_VALUE, maxAge.getAge());
        
        try {
            final Person negativeAge = new Person(name, -1);
            Assertions.assertNotReached();
        } catch (Throwable t) {
            Assertions.assertExpectedThrowable(
                IllegalArgumentException.class, t);
        }

        System.out.println("testPerson success");
    }
    
    private void testGetAge() {
        final Person p = new Person("Bob", 45);
        
        Assertions.assertEquals(45, p.getAge());
        
        System.out.println("testGetAge success");
    }
    
    private void testGetName() {
        final Person p = new Person("Bob", 45);
        
        Assertions.assertEquals("Bob", p.getName());
        
        System.out.println("testGetName success");
    }
    
    private void testEquals() {
        final Person p = new Person("Jane", 20);
        
        Assertions.assertTrue(p.equals(p));
        
        Assertions.assertFalse(p.equals(null));
        
        Assertions.assertFalse(p.equals("Jane"));
        
        Assertions.assertTrue(p.equals(new Person("Jane", 20)));
        
        Assertions.assertFalse(p.equals(new Person("Jane", 21)));
        
        Assertions.assertFalse(p.equals(new Person("jane", 20)));
        
        Assertions.assertFalse(p.equals(new Person("Jan", 20)));
        
        System.out.println("testEquals success");
	}
}


