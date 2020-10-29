package Moves.Simisage;

import ru.ifmo.se.pokemon.*;

public class Rock_Slide extends PhysicalMove {
    public Rock_Slide(){
        super(Type.ROCK,75,90);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
        if (Math.random() <= 0.3) {
            def.setMod(Stat.HP, (int) Math.round(damage));
            Effect.flinch(def);
        }
    }

    @Override
    protected String describe() {
        return "Rock Slide";
    }
}
