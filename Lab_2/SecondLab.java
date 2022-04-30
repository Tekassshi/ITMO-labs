import ru.ifmo.se.pokemon.*;
import Pokemons.*;

public class SecondLab {
    public static void main(String[] args) {

        Battle b = new Battle();

        Flygon p1 = new Flygon(" ДОРА", 10);
        Togedemaru p2 = new Togedemaru("ДАЖА", 13);
        Cubone p3 = new Cubone("ЛОХТЫ", 40);

        Marowak p4 = new Marowak("ЧУДИЛА7ЧЕБУПЕЛЬ", 2);
        Trapinch p5 = new Trapinch("ДАНЫЛА", 15);
        Vibara p6 = new Vibara("РАНИМЫЙ", 38);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);

        b.go();
    }
}