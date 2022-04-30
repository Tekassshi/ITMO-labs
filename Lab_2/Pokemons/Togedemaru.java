package Pokemons;

import ru.ifmo.se.pokemon.*;
import Moves.StatusMoves.*;
import Moves.SpecialMoves.*;

public class Togedemaru extends Pokemon {
    public Togedemaru(String var1, int var2) {

        super(var1, var2);
        this.setType(Type.valueOf("ELECTRIC"), Type.valueOf("STEEL"));
        this.setStats(65.0D, 98.0D, 63.0D, 40.0D, 73.0D, 96.0D);

        this.setMove(new Growl(), new HealPulse(), new Confusion(), new Thunderbolt());
    }
}