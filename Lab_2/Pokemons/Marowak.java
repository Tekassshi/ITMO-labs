package Pokemons;

import Moves.SpecialMoves.SilverWind;
import ru.ifmo.se.pokemon.Type;

public class Marowak extends Cubone{
    public Marowak(String var1, int var2){
        super(var1, var2);
        this.setType(Type.valueOf("GROUND"));
        this.setStats(60,80,110,50,80,45);
        this.setMove(new SilverWind());
    }
}