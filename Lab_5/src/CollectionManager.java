import Classes.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CollectionManager {

    //Вывод коллекции в json
    public static void toJson(LinkedList collection){

        String json_out = new String("collection.json");
        String s = new String("");
        Movie m = new Movie();

        s += "[\n\t";

        for (int i = 0; i < collection.size(); i++){
            m = (Movie) collection.get(i);

            s +=
                    "{\n\t" +
                    "\t\"id\":" + m.getId() + "," +
                    "\n\t\t\"name\":" + m.getName() + "," +
                            "\n\t\t\"coordinates\":" + m.getCoordinates() + "," +
                    "\n\t\t\"creationDate\":" + "\"" + m.getCreationDate() + "\"" + "," +
                    "\n\t\t\"oscarsCount\":" + m.getOscarsCount() + "," +
                    "\n\t\t\"goldenPalmCount\":" + m.getGoldenPalmCount() + "," +
                    "\n\t\t\"genre\":" + m.getGenre() + "," +
                    "\n\t\t\"mpaaRating\":" + m.getMpaaRating() + "," +
                    "\n\t\t\"operator\":" + m.getOperator() +
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
//    public static LinkedList jsonParce(String filename){
//        LinkedList collection = new LinkedList<>();
//
//
//    }

}
