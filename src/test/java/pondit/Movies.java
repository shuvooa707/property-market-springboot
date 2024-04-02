package pondit;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movies {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Lord of The Rings", 2000));
        movies.add(new Movie("Batman Begins", 2006));
        movies.add(new Movie("Avenger", 2008));
        movies.add(new Movie("Joker", 2021));

//        movies.sort((Movie left, Movie right) -> left.year - right.year);

        Comparator<Movie> movieComparator = (Movie left, Movie right) -> left.year - right.year;
        Collections.sort(movies, movieComparator);

        movies
          .stream()
          .forEach((Movie movie) -> { System.out.println(movie.title); } );

    }

}


@Data
class Movie implements Comparable {
    String title;
    int year;

    Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    /**
     * @param o the object to be compared.
     * @return int
     */
    public int compareTo(Object o) {
        Movie movie = (Movie) o;
        return movie.year - year;
    }
}