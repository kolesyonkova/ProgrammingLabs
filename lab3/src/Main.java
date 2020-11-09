import Persons.Kyungs;
import Persons.LittleRu;
import Persons.Tiger;

public class Main {
    public static void main(String[] args){
        LittleRu LittleRu=new LittleRu("Крошка Ру");
        Tiger Tiger=new Tiger("Тигра");
        Kyungs Kyung=new Kyungs("Кенга");
        public enum isHome { home, forest}
        isHome location=isHome.home;
        if (location.equals(isHome.home)){
            Kyung.pourTea();
            LittleRu.say();
            Tiger.say();
            LittleRu.push();
            Tiger.push();
            Kyung.say();
            location=isHome.forest;
        }
        if (location.equals(isHome.home)) {
            LittleRu.throwСones();
            Tiger.throwСones();
            LittleRu.forgetCart();
            LittleRu.returnHome();
            Tiger.returnHome();
        };
        location=isHome.home;
    }
}
