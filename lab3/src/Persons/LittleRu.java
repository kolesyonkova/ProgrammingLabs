package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;

public class LittleRu extends Person implements MovesInHome, MovesInForest {
    public LittleRu(String name) {
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
        System.out.println("А я уже принял");
    }

    @Override
    public void turnChair() {
        System.out.println("случайно перевернул один, нарочно");
    }

    @Override
    public void push() {
        System.out.println("Толкаю Тигру");
        this.turnChair();
    }

    @Override
    public void throwСones() {
        System.out.println("КИдаю шишкой в Тигру");
    }

    @Override
    public void forgetCart() {
        System.out.println("Забыл корзину");
    }

    @Override
    public void returnHome() {
        System.out.println("Вернулся домой");
        System.out.println("обедает");
    }
}
