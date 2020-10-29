package Moves.Chimchar;

import ru.ifmo.se.pokemon.*;

public class Shadow_Claw extends PhysicalMove {
    public Shadow_Claw(){
        super(Type.GHOST,70,100);
    }
    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        return 1d / 8d;
    }
    @Override
    protected String describe() {
        return "Shadow Claw";
    }
}
