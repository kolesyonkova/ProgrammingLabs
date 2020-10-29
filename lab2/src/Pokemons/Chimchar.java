package Pokemons;

import Moves.Chimchar.Shadow_Claw;
import Moves.Pansage.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Chimchar extends Pokemon {
    public Chimchar(String name,int level){
        super(name,level);
        super.setType(Type.FIRE);
        super.setStats(44,58,44,58,44,61);
        setMove(new Facade(),new Shadow_Claw());
    }
}
