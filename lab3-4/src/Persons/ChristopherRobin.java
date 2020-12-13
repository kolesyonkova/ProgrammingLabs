package Persons;

import Location.LocForPersons;
import Moves.ChangeLoc;
import Objects.inHome.Dinner;

public class ChristopherRobin extends Person implements ChangeLoc {
    public ChristopherRobin(String name) {
        super(name);
    }

    LocForPersons loc = LocForPersons.FOREST;

    public void look(Dinner dinner) {
        class Eyes {
            String watch(Object onWhat) {
                return " заглянул в " + onWhat;
            }
        }
        Eyes eyes = new Eyes();
        dinner.overDinner();
        Door door = new Door();
        if (door.getCondition()) {
            door.openDoor();
        } else {
            door.closeDoor();
        }
        System.out.println("Обед как раз подходил к концу, когда " + getName() + eyes.watch(door));

    }

    @Override
    public void changeLoc(LocForPersons e) {
        loc = e;
    }

    @Override
    public LocForPersons getLoc() {
        return loc;
    }

    public static class Door {
        private boolean isClosed = true;

        public void closeDoor() {
            isClosed = true;
        }

        public void openDoor() {
            isClosed = false;
        }

        public boolean getCondition() {
            return isClosed;
        }

        @Override
        public String toString() {
            return "дверь";
        }
    }

}
