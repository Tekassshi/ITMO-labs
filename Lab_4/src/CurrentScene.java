import Exceptions.*;
import Interfaces.*;
import my_classes.*;

public class CurrentScene {

    //Создание объектов и персонажей (ЛР 3)

    //Дом
    public static class House extends Place {
        @Override
        public void getName(){
            System.out.println(name);
        }

        public void from(){
            System.out.print(" из домов, ");
        }
        public void to(){
            System.out.print("в дома");
        }
        public void aLotOf(){
            System.out.print("дома");
        }
        public House (String name){
            super(name);
        }
    }

    // Мостовые
    public static class Pavement extends Place{
        @Override
        public void getName(){
            System.out.println(name);
        }
        public void from(){
            System.out.print("на мостовых");
        }
        public Pavement (String name){
            super(name);
        }
    }

    //Улица
    public static class Street extends Place{
        @Override
        public void getName() {
            System.out.print(name + ' ');
        }

        public void from(){
            System.out.print("на улицах ");
        }

        public Street(String name){
            super(name);
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
    public static class Telescope extends Subject {
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

        // Расширение (ЛР4)
        public void every(){
            System.out.print("каждый коротышка");
        }
        public void size(){
            System.out.print(" с маковое зернышко");
        }
        public void diminutivalName(){
            System.out.print("крошки");
        }
        public void runOut(){
            System.out.print(" выбегали");
        }
        public void headsUp(){
            System.out.print("задирали кверху свои головёнки");
        }
        public void sayHello(){
            System.out.print(" и приветливо махали руками.");
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

        // Расширение (ЛР4)
        public void who(){
            System.out.print("У Знайки");
        }


        public void excellentVision() throws BadVisionEcxeption {
            // Зрение (локальный класс)
            class Vision extends Subject{
                Double v = Math.random()*10 - 5;


                public Double getVisionValue(){
                    return v;
                }

                public Vision(String name){
                    super(name);
                }
            }

            Vision vision = new Vision("Зрение");

            if (vision.getVisionValue() < 0){
                throw new BadVisionEcxeption("У знайки плохое зрение");
            }

            System.out.print("было очень острое "); vision.getName();
        }

        public void changeRocketDirection(){
            System.out.print("перевёл ракету в горизонтальное положение");
        }
        public void mechanismOn(){
            System.out.print("Включив механизм поворота");
        }
        public void powerOn(){
            System.out.print("включил");
        }
        public void rightDirection(){
            System.out.print("взял курс");
        }
        public void dontLeft(){
            System.out.print("который ни на секнудну не отходил от пульта управления");
        }
        public void sometimesCheck(){
            System.out.print("время от времени поглядывал в" + enums.subjects.BINOCULARS.getName());
        }
        public void canSaw(){
            System.out.print("он сумел разглядеть с высоты");
        }
        public void getDown(){
            System.out.print("повёл корабль на снижение");
        }
    }

    //Стекляшкин
    public static class Steklyashkin extends Hero implements mainh_actions{
        public Steklyashkin(String name, Place place){
            super(name,place);
        }

        // Расширение (ЛР4)
        public void saw(){
            System.out.print("увидел");
        }
        public void thought(){
            System.out.print("подумал");
        }
        public void noticed(){
            System.out.print("но вскоре заметил");
        }
    }

    //Отряды полицейских
    public static class Policemens extends Hero implements uglyh_actions {
        public void showLook(){
            System.out.print("в блестящих металлических касках.");
        }
        public Policemens(String name, Place place){
            super(name,place);
        }

        // Расширение (ЛР4)
        public void tools(){
            System.out.print("вооруженных винтовками");
        }
        public void toolsInHands(){
            System.out.print("что у них в руках просто палки");
        }
        public void successfulHit() throws FailStrikeException{

            double a;
            a = Math.random() * 10;

            if (a <= 5){
                throw new FailStrikeException(" не удалось попасть в ракету!");
            }

            System.out.print("удалось попасть");
        }
        public void who(){
            System.out.print("полицейских");
        }
    }

    //Добавление объектов и персонажей (ЛР 4)

    /* Расширение класса Subject */

    //Ракета
    public static class Rocket extends Subject{

        public Rocket(String name) {
            super(name);
        }

        public void rounds(){
            System.out.print("описывала круги");
        }
        public void flinch(){
            System.out.print("вздрогнула");
        }
        public void lostControl(){
            System.out.print(" и, потеряв управление начала переворачиваться в воздухе.");
        }
        public void locate(){
            System.out.print("находилась");
        }

        public void condition(){

            //Невесомость (локальный класс)
            class ZeroGravity extends Place{
                @Override
                public void getName(){
                    System.out.print(name);
                }
                public void where(){
                    System.out.print("находилась в состоянии невесомости, ");
                }
                public ZeroGravity(String name){
                    super(name);
                }
            }
            ZeroGravity zeroGravity = new ZeroGravity("Состояние невесомости");
            zeroGravity.where();
        }
    }

    //Огоньки вспышек
    public static class Lightnings extends Subject{
        public Lightnings(String name){
            super(name);
        }

        public void breakOut(){
            System.out.print("вырываются");
        }
    }

    //Пуля
    public static class Bullet extends Subject{
        public Bullet(String name){
            super(name);
        }

        public void fail(){
            System.out.print(" не смогла пробить прочную стальную оболочку");
        }
    }

    //Толчок
    public static class Push extends Subject{
        public Push(String name){
            super(name);
        }

        public void from(){
            System.out.print(", произведённый пулей,");
        }
        public void power(){
            System.out.print(" был для неё особенно ощутим.");
        }
    }

    //Замешательство
    public static class Confusion extends Subject{
        public Confusion(String name){
            super(name);
        }

        public void done(){
            System.out.print(" Произошло ");
        }
    }

    //Звонкий удар
    public static class Strike extends Subject{
        public Strike(String name){
            super(name);
        }

        public void wasHeard(){
            System.out.print("Послышался ");
        }
    }

    /* Расширение класса Place */

    //Анонимный класс
    static Place city = new Place("Город") {
        @Override
        public void getName(){
            System.out.print(name);
        }
        public void from(){
            System.out.print("из города");
        }
        public void which(){
            System.out.print("видневшийся вдали");
        }
        public void City(String name){
            this.name = name;
        }
    };

    //Фантомас
    public static class Fantomas extends Place{
        @Override
        public void getName(){
            System.out.print(name);
        }
        public void from(){
            System.out.print("из Фантомаса");
        }
        public void upside(){
            System.out.print("над Фантомасом");
        }
        public Fantomas(String name){
            super(name);
        }
    }

    //Крыши домов
    public static class Roofs extends Place{
        @Override
        public void getName(){
            System.out.print(name);
        }
        public void where(){
            System.out.print("на крышах домов");
        }
        public Roofs(String name){
            super(name);
        }
    }

    //Места (космонавтов)
    public static class Seats extends Place{
        @Override
        public void getName(){
            System.out.print(name);
        }
        public void from(){
            System.out.print("со своих мест");
        }
        public Seats(String name){
            super(name);
        }
    }

    public static class Astronauts extends Hero{
        public Astronauts(String name, Place place){
            super(name, place);
        }

        public void fallDown(){
            System.out.print("попадали со своих мест.");
        }
        public void reasonFallDown(){
            System.out.print("От внезапного изменения курса");
        }
    }

}