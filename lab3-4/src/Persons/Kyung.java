package Persons;

import Location.LocForPersons;
import Moves.ChangeLoc;
import Objects.inHome.Cup;

public class Kyung extends Person implements ChangeLoc {
    public Kyung(String name) {
        super(name);
    }

    LocForPersons loc = LocForPersons.HOME;

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
        class FishOil {
            private final String name;

            FishOil(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
        FishOil fishOil = new FishOil("рыбий жир");
        System.out.println("Первое, что сказала Кенга, увидав его, это: \"А вот и наш милый Тигра! Как раз пора принимать " + fishOil.getName() + "!\"-сказала " + getName());
        System.out.println("И она налила ему полную чашку.");

    }

    public void say(Tiger tiger, LittleRu littleRu) {
        System.out.println("ИДите в лес!");
        tiger.changeLoc(LocForPersons.FOREST);
        littleRu.changeLoc(LocForPersons.FOREST);
    }

    @Override
    public void changeLoc(LocForPersons e) {
        loc = e;
    }

    @Override
    public LocForPersons getLoc() {
        return loc;
    }
}
