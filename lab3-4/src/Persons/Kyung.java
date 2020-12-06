package Persons;

import Objects.inHome.Cup;

public class Kyung extends Person {
    public Kyung(String name) {
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

    public void fillCup(Cup cup) {
        cup.fillTheCup();
        class FishOil{
            private String name;
            FishOil(String name){
                this.name=name;
            }
            public String getName(){
                return name;
            }
        }
        FishOil fishOil=new FishOil("рыбий жир");
        System.out.println("Первое, что сказала Кенга, увидав его, это: \"А вот и наш милый Тигра! Как раз пора принимать "+fishOil.getName()+"!\"-сказала " + getName());
        System.out.println("И она налила ему полную чашку.");
    }

    public void say() {
        System.out.println("ИДите в лес!");

    }
}
