package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;
import Objects.inForest.Cart;
import Objects.inForest.Cones;
import Objects.inHome.Cup;

import static Objects.inHome.Chair.beThrown;

public class Tiger extends Person implements MovesInHome, MovesInForest {

    public Tiger(String name) {
        super(name);
    }

    public Cart cartTi = new Cart();

    @Override
    public void getLocation() {
        super.getLocation();
    }

    @Override
    public void setLocation(boolean location) {
        super.setLocation(location);
    }

    public void takeCup(Cup cup) {
        cup.take(getName());
        cup.empty(getName());
        say();
    }

    @Override
    public void say() {
        System.out.println(getName() + " проглотив все, что было в чашке, сказал: \"И я тоже\"");
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

    @Override
    public void returnHome() {
        System.out.println("Вернулся домой " + getName());
        System.out.println("обедает " + getName());
    }

    public void take(String name) {
        cartTi.take(getName());
    }

    public void forget(String name) {
        cartTi.forget(getName());
    }
}
