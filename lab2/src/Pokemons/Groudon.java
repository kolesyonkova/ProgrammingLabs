package Pokemons;
import Moves.Groudon.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Groudon extends Pokemon {
    public Groudon(String name,int level){
        super(name,level);
        super.setType(Type.GROUND);
        super.setStats(100,150,140,100,90,90);
        setMove(new Bulk_Up(),new Rest(),new Ancient_Power(),new Swagger());
    }

}
