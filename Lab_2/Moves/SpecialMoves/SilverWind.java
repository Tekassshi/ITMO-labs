package Moves.SpecialMoves;

import ru.ifmo.se.pokemon.*;

public class SilverWind extends SpecialMove {
    public SilverWind(){
        this.type = Type.BUG;
        this.power = 60;
        this.accuracy = 100;
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        if (Math.random() <= 0.1){
            p.setMod(Stat.ATTACK, + 1);
            p.setMod(Stat.DEFENSE, + 1);
            p.setMod(Stat.SPECIAL_ATTACK, + 1);
            p.setMod(Stat.SPECIAL_DEFENSE, + 1);
            p.setMod(Stat.SPEED, + 1);
        }
    }

    @Override
    protected String describe(){
        return "Использует Silver Wind";
    }
}