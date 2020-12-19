package objects.inForest;

import moves.ForObjects;

public class Cart implements ForObjects {
    private boolean isCart = true;

    public boolean isCart() {
        return isCart;
    }


    @Override
    public void empty(String name) {

    }

    @Override
    public boolean getIsEmpty() {
        return false;
    }

    @Override
    public void take(String name) {
        isCart = true;
        System.out.println(name + " взял корзину!");
    }

    @Override
    public void forget(String name) {
        isCart = false;
    }

    @Override
    public String toString() {
        return "корзина";
    }
}
