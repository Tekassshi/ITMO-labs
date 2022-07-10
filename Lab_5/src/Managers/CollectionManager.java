package Managers;

import Classes.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class CollectionManager {

    private static LocalDateTime creationTime;
    private static String filepath;

    public static LocalDateTime getCreationDateTime(){
        return creationTime;
    }

    public static void setFilePath(String path){
        filepath = path;
    }

    public static Long getNewId(LinkedList collection){
        return ((Movie) collection.get(collection.size()-1)).getId() + 1;
    }

    //Вывод коллекции в json
    public static void toJson(LinkedList collection){

        String json_out = new String(filepath);
        String s = new String("");
        Movie m = new Movie();

        s += "[\n\t";

        for (int i = 0; i < collection.size(); i++){
            m = (Movie) collection.get(i);

            s +=    "{\n\t" +
                    "\t\"id\":\"" + m.getId() + "\"," +
                    "\n\t\t\"name\":\"" + m.getName() + "\"," +
                    "\n\t\t\"coordinates\": {\t\t\t";

                    if (m.getCoordinates() != null) {
                        s += "\n\t\t\t\"x\":\"" + m.getCoordinates().getX() + "\"," +
                             "\n\t\t\t\"y\":\"" + m.getCoordinates().getY() + "\"\n\t\t},";
                    }
                    else{
                        s += "\n\t\t\t\"x\":\"" + null + "\"," +
                                "\n\t\t\t\"y\":\"" + null + "\"\n\t\t},";
                    }

            s +=    "\n\t\t\"creationDate\":" + "\"" + m.getCreationDate().toString().substring(0, 19) + "\"" + "," +
                    "\n\t\t\"oscarsCount\":\"" + m.getOscarsCount() + "\"," +
                    "\n\t\t\"goldenPalmCount\":\"" + m.getGoldenPalmCount() + "\"," +
                    "\n\t\t\"genre\":\"" + m.getGenre() + "\"," +
                    "\n\t\t\"mpaaRating\":\"" + m.getMpaaRating() + "\"," +
                    "\n\t\t\"operator\": {";

                    if (m.getOperator() != null) {
                        s += "\n\t\t\t\"Name\":\"" + m.getOperator().getName() + "\"," +
                                "\n\t\t\t\"Height\":\"" + m.getOperator().getHeight() + "\"," +
                                "\n\t\t\t\"EyeColor\":\"" + m.getOperator().getEyeColor() + "\"," +
                                "\n\t\t\t\"HairColor\":\"" + m.getOperator().getHairColor() + "\" \n\t\t}";
                    }
                    else {
                        s += "\n\t\t\t\"Name\":\"" + null + "\"," +
                                "\n\t\t\t\"Height\":\"" + null + "\"," +
                                "\n\t\t\t\"EyeColor\":\"" + null + "\"," +
                                "\n\t\t\t\"HairColor\":\"" + null + "\" \n\t\t}";
                    }

            s += "\n\t}";

            if (i != collection.size() -1){
                s += ",\n\t";
            }
        }

        s += "\n]";

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(json_out))){
            writter.write(s);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //Чтение коллекции из json файла
    public static LinkedList jsonParce() throws IOException, FileNotFoundException {
        LinkedList collection = new LinkedList<>();

        String json_file = new String();

        FileReader fileReader = new FileReader(filepath);
        Scanner scanner = new Scanner(fileReader);

        json_file = Files.readString(Paths.get(filepath));
        json_file = json_file.replaceAll("[{}\t\n\\[\\]\" ]", "");

        List<String> elements = new ArrayList<String>(Arrays.asList(json_file.split(",")));

        int k = 0;
        int index = 0;

        //Считываем коллекцию полностью
        while (k < elements.size()-1){

            // Флаги корректного считывания поля
            int[] flag_array = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            Movie person = new Movie();
            Coordinates coordinates = new Coordinates();
            Person operator = new Person();

            // Считываем объект коллекции
            while (index < elements.size()){
                try {
                    //Создаем список ключ-значение
                    List<String> values = new ArrayList<String>(Arrays.asList(elements.get(index).split(":")));

                    if ((values.get(0)).equals("id")) {
                        if (flag_array[0] == 1)
                            break;

                        person.setId(Long.parseLong(values.get(1)));
                        flag_array[0] = 1;
                    }
                    else if ((values.get(0)).equals("name")) {
                        person.setName(values.get(1));
                        flag_array[1] = 1;

                    } else if ((values.get(0)).equals("coordinates") && (values.get(1)).equals("x")) {
                        coordinates.setX(Long.parseLong(values.get(2)));
                        person.setCoordinates(coordinates);
                        flag_array[2] = 1;

                    } else if (((values.get(0)).equals("y") || (values.get(1)).equals("y"))) {
                        if ((values.get(0)).equals("y")){
                            coordinates.setY(Double.parseDouble(values.get(1)));
                        }
                        else {
                            coordinates.setY(Double.parseDouble(values.get(2)));
                        }
                        person.setCoordinates(coordinates);
                        flag_array[3] = 1;


                    } else if ((values.get(0)).equals("creationDate")) {
                        String dateTime = values.get(1) + ":" + values.get(2) + ":" + values.get(3);
                        person.setCreationDate(LocalDateTime.parse(dateTime));
                        flag_array[4] = 1;

                    } else if ((values.get(0)).equals("oscarsCount")) {
                        person.setOscarsCount(Long.parseLong(values.get(1)));
                        flag_array[5] = 1;


                    } else if ((values.get(0)).equals("goldenPalmCount")) {
                        person.setGoldenPalmCount(Long.parseLong(values.get(1)));
                        flag_array[6] = 1;

                    } else if ((values.get(0)).equals("genre")) {
                        person.setGenre(MovieGenre.valueOf(values.get(1)));
                        flag_array[7] = 1;

                    } else if ((values.get(0)).equals("mpaaRating")) {
                        person.setMpaaRating(MpaaRating.valueOf(values.get(1)));
                        flag_array[8] = 1;

                    } else if ((values.get(0)).equals("operator") && (values.get(1)).equals("Name")) {
                        operator.setName(values.get(2));
                        person.setOperator(operator);
                        flag_array[9] = 1;

                    } else if (values.get(0).equals("Height") || (values.get(1)).equals("Height")) {

                        if ((values.get(0)).equals("Height")){
                            operator.setHeight(Double.parseDouble(values.get(1)));
                        }
                        else operator.setHeight(Double.parseDouble(values.get(2)));

                        person.setOperator(operator);
                        flag_array[10] = 1;

                    } else if (values.get(0).equals("EyeColor") || (values.get(1)).equals("EyeColor")) {

                        if (values.get(0).equals("EyeColor")){
                            operator.setEyeColor(Color.valueOf(values.get(1)));
                        }
                        else operator.setEyeColor(Color.valueOf(values.get(2)));

                        person.setOperator(operator);
                        flag_array[11] = 1;

                    } else if (values.get(0).equals("HairColor")  || values.get(1).equals("HairColor")) {
                        if (values.get(0).equals("HairColor")) {
                            operator.setHairColor(Color.valueOf(values.get(1)));
                        }
                        else operator.setHairColor(Color.valueOf(values.get(2)));

                        person.setOperator(operator);
                        flag_array[12] = 1;

                    }
                } catch (Exception e) {
                    System.err.println("Ошибка чтения json файла. Проверьте корректность введённых данных.");
                    System.exit(1);
                }
                index += 1;
            }
            collection.add(person);

            // Увеличиваем счетчик посчитанных элементов
            k += IntStream.of(flag_array).sum();
        }
        fileReader.close();

        creationTime = LocalDateTime.now();

        Collections.sort(collection);

        return collection;
    }
}