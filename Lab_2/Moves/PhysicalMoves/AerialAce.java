package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class AerialAce extends PhysicalMove {
    public AerialAce(){
        this.type = Type.FLYING;
        this.power = 60;
        this.accuracy = 999999999;
    }

    @Override
    protected String describe(){
        return "Использует Aerial Ace";
    }
}
