package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class HealPulse extends StatusMove {
    public HealPulse(){
        this.type = Type.PSYCHIC;
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.HP, (int) (p.getHP() + (p.getStat(Stat.HP))*0.5));
    }

    @Override
    protected String describe(){
        return "Использует Heal Pulse";
    }
}
