package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;
import Objects.Cart;
import Objects.Cones;


public class LittleRu extends Person implements MovesInHome, MovesInForest{
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
    public void push() {
        System.out.println("Толкаю Тигру");
        this.turnChair();
    }


    @Override
    public void throwСones() {
        Cones con = new Cones(getName(), "Тигру");
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
