package my_classes;

import java.util.Objects;

public class Hero {
    public String name;
    public Place place;

    public void show_name(){
        System.out.print(name + ' ');
    }
    public void set_place(Place place){
        this.place = place;
    }
    Hero(String name, Place place){
        this.name = name;
        this.place = place;
    }


    // переопределение базовых методов
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if ((this.getClass() != obj.getClass()) || (obj == null)){
            return false;
        }

        Hero hero = (Hero) obj;

        return (this.name == hero.name && this.place == hero.place);

    }

    @Override
    public int hashCode(){
        return Objects.hash(name, place);
    }

    @Override
    public String toString(){
        return "{name = '" + name + "', " + "place = " + place + "}";
    }
}