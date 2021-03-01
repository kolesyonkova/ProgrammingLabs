package persons;

import location.LocForPersons;
import moves.ChangeLoc;
import moves.MovesInForest;
import moves.MovesInHome;
import objects.inForest.Cart;
import objects.inForest.Cones;
import objects.inHome.Dinner;

import static objects.inHome.Chair.beThrown;


public class LittleRu extends Person implements MovesInHome, MovesInForest, ChangeLoc {
    public LittleRu(String name) {
        super(name);
    }

    LocForPersons loc = LocForPersons.HOME;
    public Cart cartRu = new Cart();

    @Override
    public void getLocation() {
        super.getLocation();
    }

    @Override
    public void setLocation(boolean location) {
        super.setLocation(location);
    }

    @Override
    public void say() {
        System.out.println(getName() + " с радостью заявил:\"А я уже принял!\"");
    }

    @Override
    public void turnChair(String name, boolean isRandom, int count) {
        beThrown(getName(), isRandom, count);
    }

    @Override
    public void turnChair(String name, boolean isRandom, int count, int count2) {
        beThrown(getName(), isRandom, count, count2);
    }

    @Override
    public void push(String thrown, boolean isAggressive) {
        if (isAggressive) {
            System.out.println(getName() + " толкнул агрессивно" + thrown);
        } else {
            System.out.println(getName() + " толкнул дружески " + thrown);
        }
    }

    @Override
    public void throwСones(String thrown) {
        Cones con = new Cones(getName(), thrown);
        con.beThrow(con);
    }

    public void take(String name) {
        cartRu.take(getName());
    }

    public void forget(String name) {
        cartRu.forget(getName());
    }

    public void startDinner(Dinner dinner) {
        dinner.setDinner();
    }

    @Override
    public void returnHome() {
        System.out.println("Вернулся домой " + getName());
        System.out.println("обедает " + getName());
        loc = LocForPersons.HOME;
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
