package objects.inForest;

import persons.Person;

public class Tree {
    private String name;

    Tree(String name) {
        this.name = name;
    }

    public static Tree pine = new Tree("Сосна");

    public static void forgetUnderTree(Person p, Cart cart, Tree tree) {
        System.out.print("За этим приятным занятием забыл зачем пришёл, а заодно ");
        System.out.println(p.getName() + " забыл объект-" + cart + " под деревом-" + tree);
        cart.forget(p.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
