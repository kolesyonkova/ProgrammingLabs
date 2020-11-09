package Persons;

import Moves.MovesInForest;
import Moves.MovesInHome;

public class Kyungs extends Person {
    public Kyungs(String name) {
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
    public void pourTea(){
        System.out.println("ВОт вам чай");
    };
    public void say(){
        System.out.println("ИДите в лес!");
    };
}
