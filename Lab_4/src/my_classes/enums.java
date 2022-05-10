package my_classes;

public class enums {
    public enum outdoor_subjects {
        SIDEWALKS ("тротуары "),
        PAVEMENTS ("мостовые"),
        CARS ("автомобили"),
        TRAMS ("трамваи"),
        BUSES ("автобусы"),
        FOOTERS ("и даже отдельных пешеходов"),
        SHIP ("корабль");

        private String title;

        outdoor_subjects(String title) {
            this.title = title;
        }

        public String getName(){
            return this.title;
        }
    }

    public enum hero_condition {
        CROWD ("толпящихся "),
        APPERARED ("высыпавшие ");

        private String title;

        hero_condition(String title) {
            this.title = title;
        }

        public String getName(){
            return this.title;
        }
    }

    public enum subjects{
        MAIN_engine ("основной двигатель"),
        BINOCULARS ("большой призматический бинокль"),
        STICKS ("палки");

        private String title;

        subjects(String title){
            this.title = title;
        }

        public String getName(){
            return this.title;
        }
    }
}
