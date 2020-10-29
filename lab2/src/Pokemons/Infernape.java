package Pokemons;

import Moves.Chimchar.Shadow_Claw;
import Moves.Infernape.Rock_Tomb;
import Moves.Monferno.Slack_Off;
import Moves.Pansage.Facade;
import ru.ifmo.se.pokemon.Type;

public class Infernape extends Monferno {
    public Infernape(String name, int level) {
        super(name,level);
        super.setType(Type.FIRE,Type.FIGHTING);
        super.setStats(64,78,52,78,52,81);
        setMove(new Facade(),new Shadow_Claw(),new Slack_Off(),new Rock_Tomb());
    }
}
