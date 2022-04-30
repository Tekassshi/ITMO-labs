package Moves.SpecialMoves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public final class Thunderbolt extends SpecialMove {
    public Thunderbolt(){
        this.type = Type.ELECTRIC;
        this.power = 90;
        this.accuracy = 100;
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1){
            Effect.paralyze(p);
        }
    }

    @Override
    protected String describe(){
        return "Использует Thunderbolt";
    }
}
