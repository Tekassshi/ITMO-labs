import Classes.Movie;

import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        int id = 0;
        int k = 0;

        LinkedList<Movie> collection = new LinkedList<>();

//        while (k < 10){
//            Movie person = new Movie();
//            id += 1;
//
//            person.setId(id);
//            person.setCreationDate(LocalDate.now());
//            person.setCoordinates();
//            collection.add(person);
//            k += 1;
//        }

        collection = CollectionManager.jsonParce("collection.json");

        CollectionManager.toJson(collection, "Output.json");

    }

}
