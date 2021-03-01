package objects.inHome;

import moves.ForObjects;
import persons.Person;

public class Cup implements ForObjects {
    private boolean isEmpty;

    public void fillTheCup() {
        isEmpty = true;
    }

    @Override
    public void empty(String name) {
        isEmpty = false;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    @Override
    public void take(String name) {

    }

    @Override
    public void forget(String name) {

    }

    public static Cup createCup(Person p) {
        System.out.println("Создала кружку " + p.getName());
        return new Cup();
    }
}
