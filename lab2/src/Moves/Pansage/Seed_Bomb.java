package Moves.Pansage;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Seed_Bomb extends PhysicalMove {
    public Seed_Bomb(){
        super(Type.GRASS,80,100);
    }
    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
    @Override
    protected String describe() {
        return "Seed Bomb";
    }
}
