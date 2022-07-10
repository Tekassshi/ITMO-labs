package Comparators;

import Classes.Movie;
import java.util.Comparator;

/** Пользовательский компаратор для сравнения объектов класса Movie по hashCode
 * @see Movie
 * */

public class SortByHashCode implements Comparator<Movie> {

    @Override
    public int compare(Movie a, Movie b){
        return a.hashCode() - b.hashCode();
    }
}
