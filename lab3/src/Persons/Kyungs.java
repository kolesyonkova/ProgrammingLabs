package Persons;

import Objects.Cup;

public class Kyungs extends Person {
    public Kyungs(String name) {
        super(name);
    }

    @Override
    public void getLocation() {
        super.getLocation();
    }

    @Override
    public void setLocation(boolean location) {
        super.setLocation(location);
    }

    public void pourTea(Cup cup) {
        cup.fillTheCup();
        System.out.println("\"ВОт вам чай\"-сказала " + getName());
    }

    public void say() {
        System.out.println("ИДите в лес!");

    }
}
