import Classes.Movie;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int id = 0;
        int k = 0;

        LinkedList<Movie> collection = new LinkedList<>();

        while (k < 5){
            Movie person = new Movie();
            id += 1;

            person.setId(id);
            person.setCreationDate();
            collection.add(person);
            k += 1;
        }

        CollectionManager.toJson(collection);
    }

}
