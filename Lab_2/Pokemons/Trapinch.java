package Pokemons;

import Moves.StatusMoves.Rest;
import Moves.StatusMoves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Trapinch extends Pokemon {
    public Trapinch(String var1, int var2){
        super(var1, var2);
        this.setType(Type.valueOf("GROUND"));
        this.setStats(45, 100,45,45,45,10);
        this.setMove(new Swagger(), new Rest());
    }
}
