package Persons;

public abstract class Person {
    private final String name;
    private boolean location;

    public void getLocation() {
        System.out.println("Находится на локации" + this.location);
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
