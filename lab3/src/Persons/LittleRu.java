package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;
import Objects.inForest.Cart;
import Objects.inForest.Cones;

import static Objects.inHome.Chair.beThrown;


public class LittleRu extends Person implements MovesInHome, MovesInForest {
    public LittleRu(String name) {
        super(name);
    }

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
    public void turnChair(String name,boolean isRandom, int count) {
            beThrown(getName(),isRandom,count);
    }
    @Override
    public void turnChair(String name,boolean isRandom, int count,int count2) {
        beThrown(getName(),isRandom,count,count2);
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

    @Override
    public void returnHome() {
        System.out.println("Вернулся домой " + getName());
        System.out.println("обедает " + getName());
    }

}
