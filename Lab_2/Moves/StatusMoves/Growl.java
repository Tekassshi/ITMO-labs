package Moves.StatusMoves;
import ru.ifmo.se.pokemon.*;

public class Growl extends StatusMove{
    public Growl(){
        this.type = Type.valueOf("NORMAL");
        this.accuracy = 100;
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect e = new Effect().chance(1).turns(1).stat(Stat.ATTACK, -1);
        p.addEffect(e);
    }

    @Override
    protected String describe(){
        return "Использует Growl";
    }
}
