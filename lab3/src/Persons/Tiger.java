package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;
import Objects.Cart;
import Objects.Cones;
import Objects.Cup;

public class Tiger extends Person implements MovesInHome, MovesInForest {

    public Tiger(String name) {
        super(name);
    }

    Cart cartTi = new Cart();

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
        Cup cup = new Cup();
        cup.drankCup();
        System.out.println(getName() + " проглотив все, что было в чашке, сказал: \"И я тоже\"");
    }

    @Override
    public void takeCart() {
        cartTi.takeCart(getName());
    }

    @Override
    public void turnChair() {
        System.out.println("Случайно перевернул один или два стула, нечаянно " + getName());
    }

    @Override
    public void push() {
        System.out.println("Толкаю Крошку Ру");
        this.turnChair();
    }

    @Override
    public void throwСones() {
        Cones con = new Cones(getName(), "Крошку Ру");
        con.beThrow(con);
    }

    @Override
    public void forgetCart() {
        cartTi.forgetCart(getName());
    }

    @Override
    public void returnHome() {
        System.out.println("Вернулся домой " + getName());
        System.out.println("обедает " + getName());
    }
}
