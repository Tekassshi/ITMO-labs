package Managers;

import Classes.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class CommandManager {

    // Основной метод для запуска программы
    public static void run() throws IOException {

        LinkedList<Movie> collection = new LinkedList<>();
        collection = CollectionManager.jsonParce();

        String command = new String();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Collection Manager ---\n\nВведите \"help\" для получения справки, \"exit\" - " +
                "для выхода.\n");

        System.out.print(">>> ");

        while (!(command = scanner.nextLine()).equals("exit")){

            if (command.equals("help")){
                CommandManager.help();
            }
            else if (command.equals("info")){
                info(collection);
            }
            else if (command.equals("show")){
                show(collection);
                System.out.println();
            }
            else if (command.equals("add")){
                add(collection);
            }
            else {
                System.out.println("\u001B[31m" + "Неверная команда. Введите \"help\" для получения справки. \n" +
                        "\u001B[0m");
            }

            System.out.print(">>> ");

        }

    }


    // help - вывести справку по всем доступным командам

    public static void help(){
        String s = new String();

        s += "\n\n--- Справка по всем доступным командам --- \n";

        s +=    "\nhelp - вывести справку по доступным командам\n\n" +
                "info - вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов и т.д.)\n\n" +
                "show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n\n"
                + "add {element} - добавить новый элемент в коллекцию\n\n" +
                "update id {element} - обновить значение элемента коллекции, id которого равен заданному\n\n" +
                "remove_by_id id - удалить элемент из коллекции по его id\n\n" +
                "clear - очистить коллекцию\n\n" +
                "save - сохранить коллекцию в файл\n\n" +
                "execute_script file_name - считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся " + "команды в таком же виде," +
                "\n\t\t\t\t\t\t   в котором их вводит пользователь в " +
                "интерактивном режиме.\n\n" +
                "exit - завершить программу (без сохранения в файл)\n\n" +
                "remove_first - удалить первый элемент из коллекции\n\n" +
                "remove_last - удалить последний элемент из коллекции\n\n" +
                "shuffle - перемешать элементы коллекции в случайном порядке\n\n" +
                "filter_less_than_mpaa_rating mpaaRating - вывести элементы, значение поля " +
                "mpaaRating которых меньше заданного\n\n" +
                "print_ascending - вывести элементы коллекции в порядке возрастания\n\n" +
                "print_field_descending_genre - вывести значения поля genre всех элементов в порядке убывания\n";

        System.out.println(s);
    }

    // info - вывести в стандартный поток вывода информацию о коллекции

    public static void info(LinkedList collection){
        System.out.println("\n--- Информация о коллекции ---");
        System.out.println("Тип: LinkedList");
        System.out.println("Дата инициализации: " + CollectionManager.getCreationDateTime().toString().substring(0, 19));
        System.out.println("Количество элементов: " + collection.size() + "\n");
    }

    // show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении

    public static void show(LinkedList collection){
        String s = new String("");
        Movie m = new Movie();

        s += "[\n\t";

        for (int i = 0; i < collection.size(); i++) {
            m = (Movie) collection.get(i);

            s += "{\n\t" +
                    "\tId: " + m.getId() + "," +
                    "\n\t\tName: " + m.getName() + "," +
                    "\n\t\tCoordinates: {\t\t\t";

            if (m.getCoordinates() != null) {
                s += "\n\t\t\tx: " + m.getCoordinates().getX() + "," +
                        "\n\t\t\ty: " + m.getCoordinates().getY() + "\n\t\t},";
            } else {
                s += "\n\t\t\tx: " + null + "," +
                        "\n\t\t\ty: " + null + "\n\t\t},";
            }

            s += "\n\t\tCreationDate: " + m.getCreationDate().toString().substring(0, 19) + "," +
                    "\n\t\tOscarsCount: " + m.getOscarsCount() + "," +
                    "\n\t\tGoldenPalmCount: " + m.getGoldenPalmCount() + "," +
                    "\n\t\tGenre: " + m.getGenre() + "," +
                    "\n\t\tMpaaRating: " + m.getMpaaRating() + "," +
                    "\n\t\tOperator: {";

            if (m.getOperator() != null) {
                s += "\n\t\t\tName: " + m.getOperator().getName() + "," +
                        "\n\t\t\tHeight: " + m.getOperator().getHeight() + "," +
                        "\n\t\t\tEyeColor: " + m.getOperator().getEyeColor() + "," +
                        "\n\t\t\tHairColor: " + m.getOperator().getHairColor() + " \n\t\t}";
            } else {
                s += "\n\t\t\tName: " + null + "," +
                        "\n\t\t\tHeight: " + null + "," +
                        "\n\t\t\tEyeColor: " + null + "," +
                        "\n\t\t\tHairColor: " + null + " \n\t\t}";
            }

            s += "\n\t}";

            if (i != collection.size() - 1) {
                s += ",\n\t";
            }
        }
        System.out.println(s);
    }

    // Функция для проверки состоит ли строка только из букв
    public static boolean isStringOfAlpha(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    // Функция для проверки состоит ли строка только из цифр
    public static boolean isStringOfNumbers(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')){
                return false;
            }
        }
        return true;
    }

    public static void add(LinkedList collection){
        Movie m = new Movie();
        Scanner scanner = new Scanner(System.in);

        m.setId(CollectionManager.getNewId(collection));

        // Имя

        System.out.print("\nВведите имя: ");
        while (true){
            String input_value = new String();
            input_value = scanner.nextLine();

            if (isStringOfAlpha(input_value)) {
                m.setName(input_value);
                break;
            }
            else{
                System.out.println("\u001B[31m" + "Имя должно состоять только из букв. Повторите ввод.\n" +
                        "\u001B[0m");
            }
            System.out.print(">>> ");
        }

        // Координаты

        System.out.print("Введите координаты (\"x\" должен являться целым числом)");
        while (true){
            Coordinates coordinates = new Coordinates();
            Long input_valueX;
            Double input_valueY;

            try {
                System.out.print("\nx: ");
                input_valueX = scanner.nextLong();

                System.out.print("y: ");
                input_valueY = scanner.nextDouble();

                coordinates.setX(input_valueX);
                coordinates.setY(input_valueY);

                m.setCoordinates(coordinates);
                break;
            }
            catch (InputMismatchException e){
                System.out.println("\u001B[31m" + "Координаты должны являться числом (\"x\" должен являться " +
                        "целым числом, десятичный разделитель - запятая). Повторите ввод." + "\u001B[0m");
                scanner.nextLine();
            }
        }

        // Число оскаров

        System.out.print("Введите количество оскаров: ");
        while (true){
            try {
                Long input_value;
                input_value = scanner.nextLong();

                m.setOscarsCount(input_value);
                break;
            }
            catch (InputMismatchException e){
                System.out.println("\u001B[31m" + "Введённое значение не является целым числом. Повторите ввод.\n"
                        + "\u001B[0m");
                System.out.print("Введите количество оскаров: ");
                scanner.nextLine();
            }
        }

        // Число золотых пальм

        System.out.print("Введите количество золотых пальм: ");
        while (true){
            try {
                Long input_value;
                input_value = scanner.nextLong();

                m.setGoldenPalmCount(input_value);
                scanner.nextLine();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("\u001B[31m" + "Введённое значение не является целым числом. Повторите ввод.\n"
                        + "\u001B[0m");
                System.out.print("Введите количество золотых пальм: ");
                scanner.nextLine();
            }
        }

        // Жанр фильма

        System.out.print("Введите жанр фильма (ACTION, FANTASY, SCIENCE_FICTION): ");
        while (true){
            try {
                String input_value;
                input_value = scanner.nextLine().toUpperCase();

                m.setGenre(MovieGenre.valueOf(input_value));
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println("\u001B[31m" + "Введённое значение некорректно. Повторите ввод.\n"
                        + "\u001B[0m");
                System.out.print("Введите жанр фильма (ACTION, FANTASY, SCIENCE_FICTION): ");
            }
        }


        // Рейтинг Mpaa

        System.out.print("Введите рейтинг Mpaa (G, PG, PG_13, NC_17): ");
        while (true){
            try {
                String input_value;
                input_value = scanner.nextLine().toUpperCase();

                m.setMpaaRating(MpaaRating.valueOf(input_value));
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println("\u001B[31m" + "Введённое значение некорректно. Повторите ввод.\n"
                        + "\u001B[0m");
                System.out.print("Введите рейтинг Mpaa (G, PG, PG_13, NC_17): ");
            }
        }

        // Person

        System.out.print("\nОператор");
        while (true){
            Person person = new Person();
            try {
                String name;
                Double height;
                Color eyeColor;
                Color hairColor;

                System.out.print("\nВведите имя: ");
                name = scanner.nextLine();

                if (isStringOfAlpha(name)) {
                    person.setName(name);
                }
                else{
                    System.out.println("\u001B[31m" + "Имя должно состоять только из букв. Повторите ввод.\n" +
                            "\u001B[0m");
                }

                System.out.print("Введите рост (десятичный разделитель - запятая): ");
                height = scanner.nextDouble();
                person.setHeight(height);
                scanner.nextLine();

                System.out.print("Введите цвет глаз (GREEN, RED, YELLOW, ORANGE, WHITE): ");
                eyeColor = Color.valueOf(scanner.nextLine().toUpperCase());
                person.setEyeColor(eyeColor);

                System.out.print("Введите цвет волос (GREEN, RED, YELLOW, ORANGE, WHITE): ");
                hairColor = Color.valueOf(scanner.nextLine().toUpperCase());
                person.setHairColor(hairColor);

                m.setOperator(person);
                break;
            }
            catch (IllegalArgumentException | InputMismatchException e){
                System.out.println("\u001B[31m" + "Введённое значение некорректно. Повторите ввод.\n"
                        + "\u001B[0m");
            }
        }

        m.setCreationDate(LocalDateTime.now());
        collection.add(m);
        System.out.println("\u001B[32m" + "\nОбъект успешно добавлен в коллекцию!\n" + "\u001B[0m");

        CollectionManager.toJson(collection);
    }
}
