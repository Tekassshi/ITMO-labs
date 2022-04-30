package my_classes;

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
}