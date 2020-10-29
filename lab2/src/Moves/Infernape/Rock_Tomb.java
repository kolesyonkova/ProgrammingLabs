package Moves.Infernape;

import ru.ifmo.se.pokemon.*;

public class Rock_Tomb extends PhysicalMove {
    public Rock_Tomb(){
        super(Type.ROCK,60,95);
    }
    @Override
    protected void applyOppDamage(Pokemon def,double damage){
        def.setMod(Stat.HP, (int) Math.round(damage));
        def.setMod(Stat.SPEED,1);
    }
    @Override
    protected String describe() {
        return "Rock Tomb";
    }
}
