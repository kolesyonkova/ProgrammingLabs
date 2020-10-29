package Moves.Monferno;

import ru.ifmo.se.pokemon.*;

public class Slack_Off extends StatusMove {
    public Slack_Off(){
        super(Type.NORMAL,0,1);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        p.setMod(Stat.HP,-3);
    }

    @Override
    protected String describe() {
        return "Slack Off";
    }
}
