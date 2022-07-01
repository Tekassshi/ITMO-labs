import Classes.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class CollectionManager {

    //Вывод коллекции в json
    public static void toJson(LinkedList collection, String filename){

        String json_out = new String(filename);
        String s = new String("");
        Movie m = new Movie();

        s += "[\n\t";

        for (int i = 0; i < collection.size(); i++){
            m = (Movie) collection.get(i);

            s +=
                    "{\n\t" +
                    "\t\"id\":\"" + m.getId() + "\"," +
                    "\n\t\t\"name\":\"" + m.getName() + "\"," +
                            "\n\t\t\"coordinates\": {\n\t\t\t" + "\"x\":\"" + m.getCoordinates().getX() + "\",\n\t\t\t"
                            + "\"y\":\"" + m.getCoordinates().getY() + "\"\n\t\t}," +
                    "\n\t\t\"creationDate\":" + "\"" + m.getCreationDate() + "\"" + "," +
                    "\n\t\t\"oscarsCount\":\"" + m.getOscarsCount() + "\"," +
                    "\n\t\t\"goldenPalmCount\":\"" + m.getGoldenPalmCount() + "\"," +
                    "\n\t\t\"genre\":\"" + m.getGenre() + "\"," +
                    "\n\t\t\"mpaaRating\":\"" + m.getMpaaRating() + "\"," +
                    "\n\t\t\"operator\": {" +
                            "\n\t\t\t\"Name\":\"" + m.getOperator().getName() + "\"," +
                            "\n\t\t\t\"Height\":\"" + m.getOperator().getHeight() + "\"," +
                            "\n\t\t\t\"EyeColor\":\"" + m.getOperator().getEyeColor() + "\"," +
                            "\n\t\t\t\"HairColor\":\"" + m.getOperator().getHairColor() + "\" \n\t\t }" +

                    "\n\t}";

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
    public static LinkedList jsonParce(String filename) throws IOException {
        LinkedList collection = new LinkedList<>();

        String json_file = new String();

        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);

        boolean f = false;

        json_file = Files.readString(Paths.get(filename));
        json_file = json_file.replaceAll("[{}\t\n\\[\\]\" ]", "");

        List<String> elements = new ArrayList<String>(Arrays.asList(json_file.split(",")));

        Movie person = new Movie();
        Coordinates coordinates = new Coordinates();
        Person operator = new Person();

        for (int i = 0; i < elements.size(); i++) {
            try {
                List<String> values = new ArrayList<String>(Arrays.asList(elements.get(i).split(":")));

                if ((values.get(0)).equals("id")) {
                    person.setId(Long.parseLong(values.get(1)));
                }
                if ((values.get(0)).equals("name")) {
                    person.setName(values.get(1));
                } else if ((values.get(0)).equals("coordinates")) {
                    coordinates.setX(Long.parseLong(values.get(2)));
                    person.setCoordinates(coordinates);
                } else if ((values.get(0)).equals("y")) {
                    coordinates.setY(Double.parseDouble(values.get(1)));
                    person.setCoordinates(coordinates);
                } else if ((values.get(0)).equals("creationDate")) {
                    person.setCreationDate(LocalDate.parse(values.get(1)));
                } else if ((values.get(0)).equals("oscarsCount")) {
                    person.setOscarsCount(Long.parseLong(values.get(1)));
                } else if ((values.get(0)).equals("goldenPalmCount")) {
                    person.setGoldenPalmCount(Long.parseLong(values.get(1)));
                } else if ((values.get(0)).equals("genre")) {
                    person.setGenre(MovieGenre.valueOf(values.get(1)));
                } else if ((values.get(0)).equals("mpaaRating")) {
                    person.setMpaaRating(MpaaRating.valueOf(values.get(1)));
                } else if ((values.get(0)).equals("operator")) {
                    operator.setName(values.get(2));
                    person.setOperator(operator);
                } else if ((values.get(0)).equals("Height")) {
                    operator.setHeight(Double.parseDouble(values.get(1)));
                    person.setOperator(operator);
                } else if ((values.get(0)).equals("EyeColor")) {
                    operator.setEyeColor(Color.valueOf(values.get(1)));
                    person.setOperator(operator);
                } else if ((values.get(0)).equals("HairColor")) {
                    operator.setHairColor(Color.valueOf(values.get(1)));
                    person.setOperator(operator);

                    collection.add(person);
                }
            } catch (Exception e) {
                System.err.println("Ошибка чтения json файла. Проверьте корректность введённых данных.");
            }

        }
        fileReader.close();
        return collection;
    }
}