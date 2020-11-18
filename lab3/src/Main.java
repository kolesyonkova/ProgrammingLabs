import Persons.Kyungs;
import Persons.LittleRu;
import Persons.Tiger;

public class Main {
    public static void main(String[] args){
        LittleRu LittleRu=new LittleRu("Крошка Ру");
        Tiger Tiger=new Tiger("Тигра");
        Kyungs Kyung=new Kyungs("Кенга");
        IsHome isHome=IsHome.HOME;
        if (isHome==IsHome.HOME){
            Kyung.pourTea();
            LittleRu.say();
            Tiger.say();
            LittleRu.push();
            Tiger.push();
            Kyung.say();
        }
        isHome=IsHome.FOREST;
        if (isHome==IsHome.FOREST) {
            LittleRu.throwСones();
            Tiger.throwСones();
            LittleRu.forgetCart();
            LittleRu.returnHome();
            Tiger.returnHome();
        };
    }
}
