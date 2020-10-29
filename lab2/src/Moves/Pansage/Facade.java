package Moves.Pansage;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL,70,100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
        if ((def.getCondition() == Status.PARALYZE)||(def.getCondition() == Status.PARALYZE)||(def.getCondition()==Status.BURN)){
            def.setMod(Stat.HP, (int) Math.round(2*damage));}
    }

    @Override
    protected String describe() {
        return "Facade";
    }
}
