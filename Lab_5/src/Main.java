import Classes.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int id = 0;
        int k = 0;

        LinkedList<Movie> collection = new LinkedList<>();

        while (k < 3){
            Movie person = new Movie();
            id += 1;

            person.setId(id);
            collection.add(person);
            k += 1;
        }

        String out_file = new String("collection.json");

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(out_file))){
            writter.write(toJson(collection));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String toJson(LinkedList collection){
        String s = new String("");
        s += "[ \n \t";
        for (int i = 0; i < collection.size(); i++){
            s += (((Movie) collection.get(i)).toJson() + "\n \t");
        }
        s += "]";
        return s;
    }
}
