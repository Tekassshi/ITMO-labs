package my_classes;

public class enums {
    public enum outdoor_subjects {
        SIDEWALKS ("тротуары "),
        PAVEMENTS ("мостовые");

        public String title;

        outdoor_subjects(String title) {
            this.title = title;
        }
    }

    public enum hero_condition {
        CROWD ("толпящихся "),
        APPERARED ("высыпавшие ");

        public String title;

        hero_condition(String title) {
            this.title = title;
        }
    }

}
