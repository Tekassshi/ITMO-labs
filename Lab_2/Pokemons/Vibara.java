package Pokemons;

import Moves.PhysicalMoves.Superpower;
import ru.ifmo.se.pokemon.Type;

public class Vibara extends Trapinch{
    public Vibara(String var1, int var2){
        super(var1, var2);
        this.setType(Type.valueOf("GROUND"), Type.valueOf("DRAGON"));
        this.setStats(50,70,50,50,50,70);
        this.setMove(new Superpower());
    }
}
