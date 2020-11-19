import Objects.Cafeteriy;
import Objects.Cup;
import Persons.Kyung;
import Persons.LittleRu;
import Persons.Tiger;

public class Main {
    public static void main(String[] args) {
        LittleRu littleRu = new LittleRu("Крошка Ру");
        Tiger tiger = new Tiger("Тигра");
        Kyung kyung = new Kyung("Кенга");
        Location isHome = Location.HOME;
        if (isHome == Location.HOME) {
            Cup b = Cafeteriy.createCup(kyung);
            kyung.pourTea(b);
            littleRu.say();
            tiger.takeCup(b);
            littleRu.push(tiger.getName(),false);
            tiger.push(littleRu.getName(),false);
            kyung.say();
        }
        isHome = Location.FOREST;
        if (isHome == Location.FOREST) {
            littleRu.throwСones(tiger.getName());
            tiger.throwСones(littleRu.getName());
            littleRu.forget(littleRu.getName());
            tiger.forget(tiger.getName());
            littleRu.returnHome();
            tiger.returnHome();
        }
    }
}
