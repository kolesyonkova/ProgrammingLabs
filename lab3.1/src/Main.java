import Objects.inForest.Tree;
import Objects.inHome.Cup;
import Persons.*;

public class Main {
    public static void main(String[] args) {
        Piglet piglet=new Piglet("Пятачок");
        WinnieThePooh winnieThePooh=new WinnieThePooh("Винни-Пух");
        LittleRu littleRu = new LittleRu("Крошка Ру");
        Tiger tiger = new Tiger("Тигра");
        Kyung kyung = new Kyung("Кенга");
        ChristopherRobin christopherRobin=new ChristopherRobin("Кристофер Робин");
        piglet.stealUp(winnieThePooh.getName()+"у","сзади");
        tiger.stopWaiting("что остальные найдут его");
        Location isHome = Location.HOME;
        if (isHome == Location.HOME) {
            int i = 0;
            Cup b = Cup.createCup(kyung);
            kyung.fillCup(b);
            littleRu.say();
            tiger.takeCup(b);
            littleRu.push(tiger.getName(), false);
            tiger.push(littleRu.getName(), false);
            littleRu.turnChair(littleRu.getName(), false, 1);
            tiger.turnChair(tiger.getName(), true, 1,2);
            kyung.say();
        }
        isHome = Location.FOREST;
        if (isHome == Location.FOREST) {
            littleRu.throwСones(tiger.getName());
            tiger.throwСones(littleRu.getName());
            Tree.forgetUnderTree(littleRu, littleRu.cartRu, Tree.pine);
            Tree.forgetUnderTree(tiger, tiger.cartTi, Tree.pine);
            littleRu.returnHome();
            tiger.returnHome();
            christopherRobin.look();
        }

    }
}
