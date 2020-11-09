package Persons;

public abstract class Person {
    private String name;
    private boolean location;
    void getLocation(){
        System.out.println(this.location);
    };

    void setLocation(boolean location) {
        this.location = location;
    }

    void getLocation(boolean location) {
        System.out.println("Находится на локации");
    }
    public Person(String name) {
        this.name = name;
    }
}
