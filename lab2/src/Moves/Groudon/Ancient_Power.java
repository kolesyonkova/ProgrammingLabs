package Moves.Groudon;

import ru.ifmo.se.pokemon.*;

public class Ancient_Power extends SpecialMove {
    public Ancient_Power(){
        super(Type.ROCK,60,100);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        if (Math.random()<=0.1){
            p.setMod(Stat.ATTACK,1);
            p.setMod(Stat.DEFENSE,1);
            p.setMod(Stat.SPECIAL_ATTACK,1);
            p.setMod(Stat.SPECIAL_DEFENSE,1);
            p.setMod(Stat.SPEED,1);
        }
    }
    @Override
    protected String describe() {
        return "Ancient Power";
    }
}
