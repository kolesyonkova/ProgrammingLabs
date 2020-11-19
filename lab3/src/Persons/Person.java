package Persons;

public abstract class Person {
    private final String name;
    private boolean location;

    public Person(String name) {
        this.name = name;
    }

    public void getLocation() {
        System.out.println("Находится на локации" + this.location);
    }

    public void setLocation(boolean location) {
        this.location = location;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) return false;
        Person man = (Person) obj;
        return name.equals(man.name);
    }

    @Override
    public int hashCode() {
        return name.length();
    }
}
