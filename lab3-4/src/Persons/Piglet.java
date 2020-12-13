package Persons;

import Location.LocForPersons;
import Moves.ChangeLoc;

public class Piglet extends Person implements ChangeLoc {
    private boolean isslightlyBehind = false;

    public Piglet(String name) {
        super(name);
    }

    LocForPersons loc = LocForPersons.FOREST;

    public void fallBehind() {
        System.out.println(getName() + "чуточку приотсал и ");
        isslightlyBehind = true;
    }

    public void overtake(String name) {
        System.out.println(getName() + "догнал" + name);
        isslightlyBehind = false;
    }

    public void stealUp(String name, String position) {
        System.out.println(getName() + " подобрался к " + name + " " + position);
    }

    @Override
    public void changeLoc(LocForPersons e) {
        loc = e;
    }

    @Override
    public LocForPersons getLoc() {
        return loc;
    }
}
