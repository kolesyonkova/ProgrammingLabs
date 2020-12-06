package Objects.inHome;

import Persons.Person;

public class Chair {
    /*private boolean overturned;

    public Chair() {
        this.overturned = false;
    }*/


    public static void beThrown(String name, boolean isRandom, int count) {
        if (isRandom) {
            if (count > 1) {
                System.out.println(name + " перевернул " + count + " стула, случайно ");
            } else {
                System.out.println(name + " перевернул " + count + " стул, случайно ");
            }
        } else {
            if (count > 1) {
                System.out.println(name + " перевернул " + count + " стула, нарочно ");
            } else {
                System.out.println(name + " перевернул " + count + " стул, нарочно ");
            }
        }
    }

    public static void beThrown(String name, boolean isRandom, int count, int count2) {
        if (isRandom) {
            System.out.println(name + " перевернул " + count + " или " + count2 + " стула, случайно ");
        } else {
            System.out.println(name + " перевернул " + count + " или " + count2 + " стула, нарочно ");
        }
    }

    @Override
    public String toString() {
        return "styl";
    }

}
