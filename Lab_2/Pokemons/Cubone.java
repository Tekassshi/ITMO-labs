package Pokemons;

import Moves.PhysicalMoves.AerialAce;
import Moves.StatusMoves.Confide;

import Moves.StatusMoves.Rest;
import ru.ifmo.se.pokemon.*;

public class Cubone extends Pokemon {
    public Cubone(String var1, int var2){
        super(var1, var2);
        this.setType(Type.valueOf("GROUND"));
        this.setStats(50, 50, 95, 40, 50, 35);
        this.setMove(new Rest(), new AerialAce(), new Confide());
    }
}
