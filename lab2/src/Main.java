import Pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Groudon groudon=new Groudon("Groudon",1);
        Pansage pansage=new Pansage("Pansage",1);
        Simisage simisage=new Simisage("Simisage",1);
        Chimchar chimchar=new Chimchar("Chimchar",1);
        Monferno monferno=new Monferno("Monferno",1);
        Infernape infernape=new Infernape("Infernape",1);

        b.addAlly(pansage);
        b.addAlly(chimchar);
        b.addAlly(infernape);

        b.addFoe(groudon);
        b.addFoe(simisage);
        b.addFoe(monferno);
        b.go();
    }
}

