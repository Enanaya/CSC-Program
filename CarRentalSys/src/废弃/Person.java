package ·ÏÆú;

 class Person {
    private String name;
    private int age;
       
    public Person(String name, int age) {
        if (name.length() == 0)
            throw new IllegalArgumentException("empty string");
        
        if (age < 0)
            throw new IllegalArgumentException("zero age");
            
        this.name = name;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if(!(o instanceof Person)) return false;
        
        Person p = (Person) o;
        
        return age == p.age 
                && name.equals(p.name);
    }
}

