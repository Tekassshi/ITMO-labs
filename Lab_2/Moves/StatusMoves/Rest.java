package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest(){
        this.type = Type.PSYCHIC;
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        Effect e = new Effect().turns(2).condition(Status.SLEEP);
        p.setMod(Stat.HP, (int) p.getStat(Stat.HP));
        p.addEffect(e);
    }

    @Override
    protected String describe(){
        return "Использует Rest";
    }
}