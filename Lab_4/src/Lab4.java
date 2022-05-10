import Exceptions.BadVisionEcxeption;
import Exceptions.FailStrikeException;
import my_classes.*;

public class Lab4 {
    public static void main(String[] args){

        //Subject
        CurrentScene.Telescope telescope = new CurrentScene.Telescope("Телескоп");
        CurrentScene.Rocket rocket = new CurrentScene.Rocket("Ракета");
        CurrentScene.Lightnings lightnings = new CurrentScene.Lightnings("Огоньки вспышек");
        CurrentScene.Bullet bullet = new CurrentScene.Bullet("Пуля");
        CurrentScene.Push push = new CurrentScene.Push("Толчок");
        CurrentScene.Confusion confusion = new CurrentScene.Confusion("Замешательство");
        CurrentScene.Strike strike = new CurrentScene.Strike("Звонкий удар");

        //Place
        CurrentScene.Street street = new CurrentScene.Street("Улица");
        CurrentScene.House house = new CurrentScene.House("Дом");
        CurrentScene.Pavement pavement = new CurrentScene.Pavement("Мостовые");
        CurrentScene.Fantomas fantomas = new CurrentScene.Fantomas("Фантомас");
        CurrentScene.Roofs roofs = new CurrentScene.Roofs("Крыши домов");
        CurrentScene.Seats seats = new CurrentScene.Seats("Места");

        //Hero
        CurrentScene.Shorties shorties = new CurrentScene.Shorties("Коротышки", house);
        CurrentScene.Znayka znayka = new CurrentScene.Znayka("Знайка", street);
        CurrentScene.Steklyashkin steklyashkin = new CurrentScene.Steklyashkin("Стекляшкин", house);
        CurrentScene.Policemens policemens = new CurrentScene.Policemens("Отряды полицейских", street);
        CurrentScene.Astronauts astronauts = new CurrentScene.Astronauts("Космонавты", seats);

        //First part of text
        System.out.println("");
        znayka.mechanismOn(); System.out.print(", " + znayka.getName() + ' '); znayka.changeRocketDirection();
        System.out.print(", \n");
        System.out.print("после чего "); znayka.powerOn();
        System.out.print(' ' + enums.subjects.MAIN_engine.getName() + " и "); znayka.rightDirection();
        System.out.print(" на "); CurrentScene.city.which(); System.out.print(' '); CurrentScene.city.getName();
        System.out.print("\n Через несколько минут "); rocket.getName(); System.out.print(" "); rocket.rounds();
        System.out.print(" над "); fantomas.upside(); System.out.print(". "); System.out.print(znayka.getName());
        System.out.print("\n"); znayka.dontLeft(); System.out.println(','); znayka.sometimesCheck();
        System.out.println(" в который"); znayka.saw(); System.out.print(" не только "); house.aLotOf();
        System.out.print(", но и ");
        System.out.print(enums.outdoor_subjects.CARS.getName()); System.out.print(", ");
        System.out.print(enums.outdoor_subjects.TRAMS.getName()); System.out.print(", ");
        System.out.print(enums.outdoor_subjects.BUSES.getName()); System.out.print(' ');
        System.out.print(enums.outdoor_subjects.FOOTERS.getName()); System.out.print(". \n");
        System.out.print("Правда, все они казались чрезвычайно крошечными: "); shorties.every(); shorties.size();

        try{
            System.out.print(". \n"); znayka.who(); System.out.print(", однако, ");
            znayka.excellentVision(); System.out.print("и "); znayka.canSaw(); System.out.println(" как эти");
            shorties.diminutivalName(); shorties.runOut(); house.from(); shorties.headsUp(); shorties.sayHello();

            System.out.println(" ");
        }
        catch (BadVisionEcxeption e){
            System.out.println("было очень плохое зрение, он не смог разглядеть коротышек!");
            System.out.println(" ");
        }

        //(Lab3) Second part of text
        System.out.println(" ");

        System.out.print("Скоро ");
        System.out.print(enums.hero_condition.APPERARED.getName());
        shorties.getPlace().from();
        System.out.print(shorties.getName()+ ' ');
        shorties.fill();
        System.out.print("все ");
        System.out.print(enums.outdoor_subjects.SIDEWALKS.getName());
        System.out.print("и ");
        System.out.print(enums.outdoor_subjects.PAVEMENTS.getName());System.out.print(". \n");
        System.out.println("Теперь уже трудно было что-нибудь разглядеть в общей массе,");
        System.out.print("и ");
        znayka.whom(); znayka.seems();
        System.out.print(", будто вся ");
        street.getName(); street.worry(); street.bubbling(); street.boil();
        System.out.println("");
        telescope.whose(); System.out.print(telescope.getName()); telescope.zoom();
        System.out.print(steklyashkin.getName() + ' '); steklyashkin.saw();
        System.out.println(", ");
        System.out.print("как ");

        policemens.getPlace().from(); policemens.appear();
        System.out.print(policemens.getName() + ' '); policemens.showLook();
        System.out.println("");
        System.out.print("Они ");
        policemens.press();
        System.out.print(enums.hero_condition.CROWD.getName());
        shorties.setPlace(pavement);
        shorties.getPlace().from(); System.out.print(" ");
        shorties.whom(); System.out.print("и, "); policemens.hit(); System.out.print(", "); policemens.move();
        System.out.print("обратно "); house.to();
        System.out.print(".");

        System.out.println("");

        //Third text part
        System.out.println("");
        System.out.print(znayka.getName() + " "); znayka.getDown();
        System.out.print(" и " + steklyashkin.getName() + " "); steklyashkin.saw();
        System.out.print(" "); roofs.where(); System.out.print(" "); policemens.who();  System.out.println(", ");
        policemens.tools(); System.out.print(". ");
        System.out.print("Сначала он "); steklyashkin.thought();
        System.out.print(" "); policemens.toolsInHands(); System.out.print(" "); steklyashkin.noticed();
        System.out.println("");
        System.out.print(" что из этих 'палок' как бы "); lightnings.breakOut(); System.out.print(" ");
        lightnings.getName(); System.out.print("с белыми облачками дыма."); System.out.println("");

        try{
            System.out.print("В это время одному полицескому "); policemens.successfulHit();System.out.print(" в ракету. ");
            strike.wasHeard(); strike.getName(); System.out.print(strike.getName()); System.out.print(".");
            System.out.print("\n");
            System.out.print(rocket.getName()); System.out.print(" "); rocket.flinch(); rocket.lostControl();
            System.out.print("\n");
            System.out.print(bullet.getName()); bullet.fail(); System.out.print(", но, поскольку ");
            System.out.print(rocket.getName()); System.out.print("\n"); rocket.condition();
            System.out.print(push.getName()); push.from(); push.power(); System.out.println("");
            astronauts.reasonFallDown(); System.out.print(" "); System.out.print(astronauts.getName());
            System.out.print(" "); astronauts.fallDown(); confusion.done(); System.out.print(confusion.getName());
            System.out.print(".");
            System.out.println("");
        }
        catch (FailStrikeException e){
            System.out.print("не удалось попасть в ракету! ");
            System.out.print("Ракета полетела дальше.");
        }
    }
}