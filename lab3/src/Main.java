import Objects.Cafeteriy;
import Objects.Cup;
import Persons.Kyungs;
import Persons.LittleRu;
import Persons.Tiger;

public class Main {
    public static void main(String[] args) {
        LittleRu LittleRu = new LittleRu("Крошка Ру");
        Tiger Tiger = new Tiger("Тигра");
        Kyungs Kyung = new Kyungs("Кенга");
        Location isHome = Location.HOME;
        if (isHome == Location.HOME) {
            Cup b=Cafeteriy.createCup(Kyung);
            Kyung.pourTea(b);
            LittleRu.say();
            Tiger.takeCup(b);
            LittleRu.push();
            Tiger.push();
            Kyung.say();
        }
        isHome = Location.FOREST;
        if (isHome == Location.FOREST) {
            LittleRu.throwСones();
            Tiger.throwСones();
            LittleRu.forgetCart();
            Tiger.forgetCart();
            LittleRu.returnHome();
            Tiger.returnHome();
        }
    }
}
