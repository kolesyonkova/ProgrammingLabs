package Moves.Pansage;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide(){
        super(Type.NORMAL,0,1);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        Effect e=new Effect().stat(Stat.SPECIAL_ATTACK,-1);
        p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "Confide";
    }
}
