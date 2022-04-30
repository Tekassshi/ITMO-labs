package Moves.SpecialMoves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Confusion extends SpecialMove {
    public Confusion(){
        this.type = Type.PSYCHIC;
        this.power = 50;
        this.accuracy = 100;
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1) {
            Effect.confuse(p);
        }
    }

    @Override
    protected String describe(){
        return "Использует Confusion";
    }
}
