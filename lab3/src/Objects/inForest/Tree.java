package Objects.inForest;

import Persons.Person;

public class Tree {
    private String name;
    Tree(String name){
        this.name=name;
    }
    public static Tree pine=new Tree("Сосна");
    public static void forgetUnderTree(Person p, Cart cart, Tree tree) {
        System.out.println(p.getName()+" забыл объект-"+cart+" под деревом-"+tree);
        cart.forget(p.getName());
    }
    @Override
    public String toString() {
        return name;
    }
}
