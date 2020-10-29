package Pokemons;

import Moves.Chimchar.Shadow_Claw;
import Moves.Monferno.Slack_Off;
import Moves.Pansage.Facade;
import ru.ifmo.se.pokemon.Type;

public class Monferno extends Chimchar {
    public Monferno(String name,int level){
        super(name,level);
        super.setType(Type.FIRE,Type.FIGHTING);
        super.setStats(76,104,71,104,71,108);
        setMove(new Facade(),new Shadow_Claw(),new Slack_Off());
    }
}
