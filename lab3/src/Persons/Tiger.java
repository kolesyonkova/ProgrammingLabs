package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;

public class Tiger extends Person implements MovesInHome, MovesInForest {

    public Tiger(String name) {
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

    @Override
    public void say() {
        System.out.println("Я тоже!");
    }

    @Override
    public void turnChair() {
        System.out.println("Случайно перевернул один или два стула, нечаянно");
    }

    @Override
    public void push() {
        System.out.println("Толкаю Крошку Ру");
        this.turnChair();
    }

    @Override
    public void throwСones() {
        System.out.println("КИдаю шишкой в Крошку Ру");
    }

    @Override
    public void forgetCart() {

    }

    @Override
    public void returnHome() {
        System.out.println("Вернулся домой Тигра");
        System.out.println("обедает Тигра");
    }
}
