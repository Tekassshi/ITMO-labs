import my_classes.*;

public class Lab3 {

    public static void main(String[] args) {
        System.setProperty("console.encoding","utf-8");

        src_classes.Telescope telescope = new src_classes.Telescope("Телескоп");

        src_classes.Street street = new src_classes.Street("Улица");
        src_classes.House house = new src_classes.House("Дом");
        src_classes.Pavement pavement = new src_classes.Pavement("Мостовые");

        src_classes.Shorties shorties = new src_classes.Shorties("Коротышки", house);
        src_classes.Znayka znayka = new src_classes.Znayka("Знайка", street);
        src_classes.Steklyashkin steklyashkin = new src_classes.Steklyashkin("Стекляшкин", house);
        src_classes.Policemens policemens = new src_classes.Policemens("Отряды полицейских", street);

        System.out.println("");

        System.out.print("Скоро ");
        System.out.print(enums.hero_condition.APPERARED.title);
        shorties.place.from();
        shorties.show_name();
        shorties.fill();
        System.out.print("все ");
        System.out.print(enums.outdoor_subjects.SIDEWALKS.title);
        System.out.print("и ");
        System.out.print(enums.outdoor_subjects.PAVEMENTS.title);System.out.print(". \n");

        System.out.println("Теперь уже трудно было что-нибудь разглядеть в общей массе,");
        System.out.print("и ");
        znayka.whom(); znayka.seems();
        System.out.print(", будто вся ");
        street.show_name(); street.worry(); street.bubbling(); street.boil();

        System.out.println("");
        telescope.whose(); telescope.show_name(); telescope.zoom();
        steklyashkin.show_name(); steklyashkin.saw();
        System.out.println(", ");
        System.out.print("как ");

        policemens.place.from(); policemens.appear(); policemens.show_name(); policemens.show_look();
        System.out.println("");
        System.out.print("Они ");
        policemens.press();
        System.out.print(enums.hero_condition.CROWD.title);
        shorties.set_place(pavement);
        shorties.place.from(); System.out.print(" ");
        shorties.whom(); System.out.print("и, "); policemens.hit(); System.out.print(", "); policemens.move();
        System.out.print("обратно "); house.to();
        System.out.print(".");

        System.out.println("");

    }
}