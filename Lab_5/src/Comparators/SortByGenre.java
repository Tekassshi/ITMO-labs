package Comparators;

import Classes.Movie;
import java.util.Comparator;

public class SortByGenre implements Comparator<Movie> {
    @Override
    public int compare(Movie a, Movie b){
        return a.getGenre().getCode() - b.getGenre().getCode();
    }
}
