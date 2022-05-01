package my_classes;

import Interfaces.*;

public class current_scene {

    //Создание объектов и персонажей

    //Дом
    public static class House extends Place{
        @Override
        public void show_name(){
            System.out.println(name);
        }
        public void from(){
            System.out.print("из домов ");
        }
        public void to(){
            System.out.print("в дома");
        }
        public House (String name){
            this.name = name;
        }
    }

    // Мостовые
    public static class Pavement extends Place{
        @Override
        public void show_name(){
            System.out.println(name);
        }
        public void from(){
            System.out.print("на мостовых");
        }
        public Pavement (String name){
            this.name = name;
        }
    }

    //Улица
    public static class Street extends Place{
        @Override
        public void show_name() {
            System.out.print(name + ' ');
        }

        public void from(){
            System.out.print("на улицах ");
        }

        public Street(String name){
            this.name = name;
        }
        public void worry(){
            System.out.print("волнуется, ");
        }
        public void bubbling(){
            System.out.print("клокочет ");
        }
        public void boil(){
            System.out.print("или кипит.");
        }
    }

    // Телескоп
    public static class Telescope extends Subject{
        public Telescope(String name) {
            super(name);
        }

        public void zoom(){
            System.out.print(", который давал значительно большее увелчение, ");
        }
        public void whose(){
            System.out.print("В свой ");
        }
    }

    //Коротышки
    public static class Shorties extends Hero implements mainh_actions {
        public Shorties(String name, Place place){
            super(name,place);
        }
        public void whom(){
            System.out.print("Коротышек ");
        }
    }

    //Знайка
    public static class Znayka extends Hero implements Interfaces.mainh_actions{
        public void whom(){
            System.out.print("Знайке ");
        }
        public Znayka(String name, Place place){
            super(name,place);
        }
    }

    //Стекляшкин
    public static class Steklyashkin extends Hero implements mainh_actions{
        public Steklyashkin(String name, Place place){
            super(name,place);
        }
    }

    //Отряды полицейских
    public static class Policemens extends Hero implements uglyh_actions {
        public void show_look(){
            System.out.print("в блестящих металлических касках.");
        }
        public Policemens(String name, Place place){
            super(name,place);
        }
    }
}