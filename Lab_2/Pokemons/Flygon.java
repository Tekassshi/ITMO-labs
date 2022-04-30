package Pokemons;

import Moves.PhysicalMoves.BrutalSwing;
import ru.ifmo.se.pokemon.Type;

public class Flygon extends Vibara{
    public Flygon(String var1, int var2){
        super(var1, var2);
        this.setType(Type.valueOf("GROUND"), Type.valueOf("DRAGON"));
        this.setStats(80, 100, 80, 80, 80, 100);
        this.setMove(new BrutalSwing());
    }
}
