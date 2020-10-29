package Pokemons;

import Moves.Pansage.*;
import Moves.Simisage.Rock_Slide;
import ru.ifmo.se.pokemon.Move;
import ru.ifmo.se.pokemon.Type;

public class Simisage extends Pansage {

    public Simisage(String name, int level) {
        super(name, level);
        super.setType(Type.GRASS);
        super.setStats(75,98,63,98,63,101);
        setMove(new Confide(),new Facade(),new Seed_Bomb(),new Rock_Slide());
    }

}
