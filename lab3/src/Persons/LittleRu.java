package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;
import Objects.Cart;
import Objects.Cones;


public class LittleRu extends Person implements MovesInHome, MovesInForest {
    public LittleRu(String name) {
        super(name);
    }

    Cart cartRu = new Cart();

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
    public void turnChair() {
        System.out.println("случайно перевернул один, нарочно " + getName());
    }

    @Override
    public void push(String thrown, boolean isAggressive) {
        if (isAggressive) {
            System.out.println(getName() + " толкнул агрессивно" + thrown);
            this.turnChair();
        } else {
            System.out.println(getName() + " толкнул дружески " + thrown);
            this.turnChair();
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
