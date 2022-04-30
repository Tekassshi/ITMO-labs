package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Superpower extends PhysicalMove {
    public Superpower() {
        this.type = Type.FIGHTING;
        this.power = 120;
        this.accuracy = 100;
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.ATTACK, -1);
        p.setMod(Stat.DEFENSE, -1);
    }

    @Override
    protected String describe(){
        return "Использует Superpower";
    }
}
