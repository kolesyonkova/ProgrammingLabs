package Persons;

public class Piglet extends Person{
    public Piglet(String name) {
        super(name);
    }
    public void fallBehind() {
        System.out.println(getName()+"чуточку приотсал и ");
    }
    public void stealUp(String name, String position){
        System.out.println(getName()+" подобрался к "+name+" "+ position);
    }
}
