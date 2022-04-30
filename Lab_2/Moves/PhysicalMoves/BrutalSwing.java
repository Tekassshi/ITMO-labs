package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.PhysicalMove;

public class BrutalSwing extends PhysicalMove {
    public BrutalSwing(){
        this.power = 60;
        this.accuracy = 100;
    }

    @Override
    protected String describe(){
        return "Использует Brutal Swing";
    }
}
