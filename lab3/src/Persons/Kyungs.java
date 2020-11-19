package Persons;

import Moves.ForObjects;
import Objects.Cup;

public class Kyungs extends Person implements ForObjects {
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


    @Override
    public void empty(String name) {

    }

    @Override
    public boolean getIsEmpty() {
        return false;
    }

    @Override
    public void take(String name) {

    }

    @Override
    public void forget(String name) {

    }
}
