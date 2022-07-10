package Comparators;

import Classes.Movie;
import java.util.Comparator;

/** Пользовательский компаратор для сравнения объектов класса Movie по полю genre
 * @see Movie
 * @see Classes.MovieGenre
 * */

public class SortByGenre implements Comparator<Movie> {
    @Override
    public int compare(Movie a, Movie b){
        return a.getGenre().getCode() - b.getGenre().getCode();
    }
}
