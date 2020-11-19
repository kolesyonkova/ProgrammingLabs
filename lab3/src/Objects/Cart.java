package Objects;

import Persons.Person;

public class Cart {
    private boolean isCart = true;

    public boolean isCart() {
        return isCart;
    }

    public void forgetCart(String name) {
        isCart = false;
        System.out.println(name + " забыл корзину под деревом!");
    }

    public void takeCart(String name) {
        isCart = true;
        System.out.println(name + " взял корзину!");
    }
}
