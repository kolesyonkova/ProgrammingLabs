package Moves.Groudon;

import ru.ifmo.se.pokemon.*;

public class Bulk_Up extends StatusMove {
    public Bulk_Up(){
        super(Type.FIGHTING,0,1);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        Effect e1=new Effect().stat(Stat.ATTACK,1);
        Effect e2=new Effect().stat(Stat.DEFENSE,1);
        p.addEffect(e1);
        p.addEffect(e2);
    }
    @Override
    protected String describe() {
        return "Bulk UP";
    }
}
