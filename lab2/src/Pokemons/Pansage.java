package Pokemons;

import Moves.Pansage.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Pansage extends Pokemon {
    public Pansage(String name,int level){
        super(name,level);
        super.setType(Type.GRASS);
        super.setStats(50,53,48,53,48,64);
        setMove(new Confide(),new Facade(),new Seed_Bomb());
    }
}
