package Comparators;

import Classes.Movie;
import java.util.Comparator;

/** ���������������� ���������� ��� ��������� �������� ������ Movie �� hashCode
 * @see Movie
 * */

public class SortByHashCode implements Comparator<Movie> {

    @Override
    public int compare(Movie a, Movie b){
        return a.hashCode() - b.hashCode();
    }
}
