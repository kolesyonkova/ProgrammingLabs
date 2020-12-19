import moves.MovesInArea;
import objects.inForest.Tree;
import objects.inHome.Cup;
import objects.inHome.Dinner;
import persons.*;

import location.LocForPersons;

public class Main {
    public static void main(String[] args) throws Exception {
        int count = 1;
        int count1 = 2;
        if (count < 0 || count1 < 0) {
            throw new NumberOfFurniture("Отрицательное количество мебели");
        }
        Piglet piglet = new Piglet("Пятачок");
        //WinnieThePooh winnieThePooh = new WinnieThePooh("Винни-Пух");
        MovesInArea winnieThePooh = new MovesInArea() {
            @Override
            public String getName() {
                return "Винни-Пух";
            }
        };

        LittleRu littleRu = new LittleRu("Крошка Ру");
        Tiger tiger = new Tiger("Тигра");
        Kyung kyung = new Kyung("Кенга");
        Dinner dinner = new Dinner();
        ChristopherRobin christopherRobin = new ChristopherRobin("Кристофер Робин");
        if ((littleRu.getLoc() == null) || (tiger.getLoc() == null)) {
            throw new IsLocation("не задана локация");
        }
        piglet.stealUp(winnieThePooh.getName() + "у", "сзади");
        tiger.stopWaiting("что остальные найдут его");

        if ((tiger.getLoc() == LocForPersons.HOME) || (littleRu.getLoc() == LocForPersons.HOME)) {
            Cup b = Cup.createCup(kyung);
            kyung.fillCup(b);
            littleRu.say();
            tiger.takeCup(b);
            littleRu.push(tiger.getName(), false);
            tiger.push(littleRu.getName(), false);
            littleRu.turnChair(littleRu.getName(), false, count);
            tiger.turnChair(tiger.getName(), true, count, count1);
            kyung.say(tiger, littleRu);
        }

        if ((tiger.getLoc() == LocForPersons.FOREST) || (littleRu.getLoc() == LocForPersons.FOREST)) {
            littleRu.throwСones(tiger.getName());
            tiger.throwСones(littleRu.getName());
            Tree.forgetUnderTree(littleRu, littleRu.cartRu, Tree.pine);
            Tree.forgetUnderTree(tiger, tiger.cartTi, Tree.pine);
            littleRu.returnHome();
            littleRu.startDinner(dinner);
            tiger.returnHome();
            tiger.startDinner(dinner);
            christopherRobin.look(dinner);
        }

    }
}
