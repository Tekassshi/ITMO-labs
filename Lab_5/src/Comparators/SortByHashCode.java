package Comparators;

import Classes.Movie;
import java.util.Comparator;

public class SortByHashCode implements Comparator<Movie> {

    @Override
    public int compare(Movie a, Movie b){
        return a.hashCode() - b.hashCode();
    }
}
