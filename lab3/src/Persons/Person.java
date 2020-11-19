package Persons;

public abstract class Person {
    private final String name;
    private boolean location;

    void getLocation() {
        System.out.println("Находится на локации" + this.location);
    }

    void setLocation(boolean location) {
        this.location = location;
    }

    public Person(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
