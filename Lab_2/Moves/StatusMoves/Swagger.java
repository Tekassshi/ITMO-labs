package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        this.type = Type.NORMAL;
        this.accuracy = 85;
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK, +2);
        p.confuse();
    }

    @Override
    protected String describe(){
        return "Использует Swagger";
    }
}
