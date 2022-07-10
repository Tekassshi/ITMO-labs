package Managers;

import Classes.*;
import Comparators.SortByGenre;
import Comparators.SortByHashCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class CommandManager {

    // Основной метод для запуска программы

    public static void run() throws IOException {

        LinkedList<Movie> collection = new LinkedList<>();
        collection = CollectionManager.jsonParce();

        String[] command = new String[]{};
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Collection Manager ---\n\nВведите \"help\" для получения справки, \"exit\" - " +
                "для выхода.\n");

        System.out.print(">>> ");

        while (!(command = scanner.nextLine().split(" "))[0].equals("exit")){

            if (command[0].equals("help")){
                help();
            }
            else if (command[0].equals("info")){
                info(collection);
            }
            else if (command[0].equals("show")){
                if (collection.size() != 0){
                    show(collection);
                }
                else {
                    System.out.println("\nКоллекция пуста!");
                }
                System.out.println();
            }
            else if (command[0].equals("add")){
                add(collection);
            }
            else if (command[0].equals("update id")){
                updateId(collection);
            }
            else if (command[0].equals("remove_by_id")){
                try {
                    remove_by_id(collection, command[1]);
                }
                catch (IndexOutOfBoundsException e){
                    remove_by_id(collection, null);
                }
            }
            else if (command[0].equals("clear")){
                collection.clear();
                System.out.println("\u001B[32m" + "\nКоллекция успешно очищена!\n" +
                        "\u001B[0m");
            }
            else if (command[0].equals("save")){
                save(collection);
            }
            else if (command[0].equals("remove_first")){
                try {
                    collection.remove(0);
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("\u001B[31m" + "Коллекция пуста! \n" +
                            "\u001B[0m");
                }
            }
            else if (command[0].equals("remove_last")){
                try {
                    collection.remove(collection.size()-1);
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("\u001B[31m" + "Коллекция пуста! \n" +
                            "\u001B[0m");
                }
            }
            else if (command[0].equals("shuffle")){
                Collections.shuffle(collection);
            }
            else if (command[0].equals("filter_less_than_mpaa_rating")){
                try {
                    filter_less_than_mpaa_rating(collection, MpaaRating.valueOf(command[1].toUpperCase()));
                }
                catch (IndexOutOfBoundsException | IllegalArgumentException e){
                    filter_less_than_mpaa_rating(collection, null);
                }
            }
            else if (command[0].equals("print_ascending")){
                print_ascending(collection);
            }
            else if (command[0].equals("print_field_descending_genre")){
                print_field_descending_genre(collection);
            }
            else if (command[0].equals("execute_script")){
                try {
                    execute_script(collection, command[1]);
                }
                catch (IndexOutOfBoundsException e){
                    execute_script(collection, null);
                }
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

    // Вывод одного объекта коллекции

    public static void show(Movie m){
        String s = new String("");

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
        System.out.println(s);
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
    }

    // Функция для проверки существования заданного id в коллекции

    public static int isIdExist(LinkedList collection, String id) throws Exception {
        boolean f = false;

        for (int i = 0; i < collection.size(); i++){
            if (((Movie) collection.get(i)).getId().toString().equals(id)){
                f = true;
                return i;
            }
        }

        if (f == false){
            throw new Exception("Введённого id не существует. Повторите ввод.");
        }
        return 0;
    }

    // Обновить id

    public static void updateId(LinkedList collection){
        Scanner scanner = new Scanner(System.in);
        String inputValue;

        while (true){
            try {
                System.out.print("\nВведите id, который хотите обновить: ");
                inputValue = scanner.nextLine();
                int index;

                index = isIdExist(collection, inputValue);

                Movie m = (Movie) collection.get(index);

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
                        System.out.print("Введите имя: ");
                        continue;
                    }
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
                        continue;
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
                        System.out.println("\u001B[31m" + "Введённое значение не является целым числом. " +
                                "Повторите ввод." + "\n" + "\u001B[0m");
                        System.out.print("Введите количество оскаров: ");
                        scanner.nextLine();
                        continue;
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
                        System.out.println("\u001B[31m" + "Введённое значение не является целым числом. " +
                                "Повторите ввод.\n" + "\u001B[0m");
                        System.out.print("Введите количество золотых пальм: ");
                        scanner.nextLine();
                        continue;
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
                        continue;
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
                        continue;
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
                            continue;
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
                        scanner.nextLine();
                        continue;
                    }
                }
                m.setCreationDate(LocalDateTime.now());

                System.out.println("\u001B[32m" + "\nОбъект с id = " + inputValue + " успешно обновлён!\n" +
                        "\u001B[0m");

                break;

            } catch (Exception e) {
                System.out.println( "\u001B[31m" + "Введённого id не существует. Id должен являться целым числом. " +
                        "Повторите ввод." + "\u001B[0m");
                continue;
            }

        }
        CollectionManager.toJson(collection);
    }

    // Удалить элемент по id

    public static void remove_by_id(LinkedList collection, String id) {
        String inputValue;
        Scanner scanner = new Scanner(System.in);
        int index;

        while (true) {
            try {
                index = isIdExist(collection, id);

                collection.remove(index);

                System.out.println("\u001B[32m" + "\nОбъект с id = " + id + " успешно удалён!\n" +
                        "\u001B[0m");
                break;

            } catch (Exception e) {
                System.out.println("\u001B[31m" + "Некорректные данные (возможно такой id не существует) " +
                        "или не передан аргумент команде. Повторите ввод." + "\u001B[0m");
                System.out.print("\nВведите id для удаления (целое число): ");
                id = scanner.nextLine();

                continue;
            }
        }
    }

    public static void save(LinkedList collection){
        Collections.sort(collection);
        CollectionManager.toJson(collection);
    }

    // Вывести элементы, значение поля mpaaRating которых меньше заданного

    public static void filter_less_than_mpaa_rating(LinkedList collection, MpaaRating rating) {
        String inputValue;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                if (rating == null){
                    System.out.print("\nВведите значение MpaaRating (G, PG, PG_13, NC_17): ");
                    rating = MpaaRating.valueOf(scanner.nextLine().toUpperCase());
                }

                int maxValue = rating.getCode();
                Movie m = new Movie();

                for (int i = 0; i < collection.size(); i++){
                    m = ((Movie) collection.get(i));
                    if (m.getMpaaRating().getCode() <  maxValue){
                        show(m);
                    }
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m" + "Некорректные данные (возможно такого значения MpaaRating " +
                        "не существует) или не передан аргумент команде. Повторите ввод." + "\u001B[0m");

                continue;
            }
        }
    }


    // Вывести элементы в порядке возрастания хэш-кодов

    public static void print_ascending(LinkedList collection){
        Collections.sort(collection, new SortByHashCode());
        for (int i = 0; i < collection.size(); i++){
            show((Movie) collection.get(i));
            System.out.println("\tHashcode: " + ((Movie) collection.get(i)).hashCode() + "\n");
        }
        Collections.sort(collection);
    }

    public static void print_field_descending_genre(LinkedList collection){
        Collections.sort(collection, new SortByGenre());
        System.out.println(" ");
        for (int i = collection.size()-1; i >= 0; i--){
            System.out.println(((Movie) collection.get(i)).getGenre());
        }
        Collections.sort(collection);
        System.out.println(" ");
    }


    // Считать и исполнить скрипт из указанного файла

    public static void execute_script(LinkedList collection, String filename) {
        Scanner consoleScanner = new Scanner(System.in);
        String[] command;

        while (true) {
            try {
                if (filename == null) {
                    System.out.print("\nВведите имя файла: ");
                    filename = consoleScanner.nextLine();
                }

                FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\" + filename);
                Scanner fileScanner = new Scanner(fileReader);

                while ((!(command = fileScanner.nextLine().split(" "))[0].equals("exit"))) {

                    if (!command[0].matches("\\S+")){
                        continue;
                    }

                    if (command[0].equals("help")) {
                        help();
                    } else if (command[0].equals("info")) {
                        info(collection);
                    } else if (command[0].equals("show")) {
                        if (collection.size() != 0) {
                            show(collection);
                        } else {
                            System.out.println("\nКоллекция пуста!");
                        }
                        System.out.println();
                    } else if (command[0].equals("add")) {
                        add(collection);
                    } else if (command[0].equals("update id")) {
                        updateId(collection);
                    } else if (command[0].equals("remove_by_id")) {
                        try {
                            remove_by_id(collection, command[1]);
                        } catch (IndexOutOfBoundsException e) {
                            remove_by_id(collection, null);
                        }
                    } else if (command[0].equals("clear")) {
                        collection.clear();
                        System.out.println("\u001B[32m" + "\nКоллекция успешно очищена!\n" +
                                "\u001B[0m");
                    } else if (command[0].equals("save")) {
                        save(collection);
                    } else if (command[0].equals("remove_first")) {
                        try {
                            collection.remove(0);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("\u001B[31m" + "Коллекция пуста! \n" +
                                    "\u001B[0m");
                        }
                    } else if (command[0].equals("remove_last")) {
                        try {
                            collection.remove(collection.size() - 1);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("\u001B[31m" + "Коллекция пуста! \n" +
                                    "\u001B[0m");
                        }
                    } else if (command[0].equals("shuffle")) {
                        Collections.shuffle(collection);
                    } else if (command[0].equals("filter_less_than_mpaa_rating")) {
                        try {
                            filter_less_than_mpaa_rating(collection, MpaaRating.valueOf(command[1].toUpperCase()));
                        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                            filter_less_than_mpaa_rating(collection, null);
                        }
                    } else if (command[0].equals("print_ascending")) {
                        print_ascending(collection);
                    } else if (command[0].equals("print_field_descending_genre")) {
                        print_field_descending_genre(collection);
                    } else if (command[0].equals("execute_script")) {
                        System.out.println("\u001B[31m" + "Команда \"execute_script\" недоступна в данном режиме!" +
                                "\u001B[0m");
                    } else {
                        System.out.println("\u001B[31m" + "Неверная команда. Введите \"help\" для получения справки. " +
                                "\n\u001B[0m");
                    }
                }
                break;
            } catch (NoSuchElementException e){
                System.out.println("\u001B[31m" + "Ваш файл пуст!" + "\u001B[0m\n");
                break;
            } catch (FileNotFoundException e) {
                System.out.println("\u001B[31m" + "Некорректные данные (возможно такого файла не существует) или " +
                        "не передан аргумент команде. Повторите ввод." + "\u001B[0m");
                System.out.print("\nВведите имя файла: ");
                filename = consoleScanner.nextLine();

                continue;
            }
        }
        System.out.println("\u001B[32m" + "Скрипт успешно исполнен!\n" +
                "\u001B[0m");
    }
}