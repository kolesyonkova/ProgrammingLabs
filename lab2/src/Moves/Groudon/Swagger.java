package Moves.Groudon;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL,0,85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        Effect.confuse(p);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        Effect e=new Effect().stat(Stat.ATTACK,2);
        p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "Swagger";
    }
}
