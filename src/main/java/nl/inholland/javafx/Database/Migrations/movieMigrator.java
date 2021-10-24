package nl.inholland.javafx.Database.Migrations;

import nl.inholland.javafx.Model.Theater.Movie;

import java.util.ArrayList;
import java.util.List;

public class movieMigrator {

    public List<Movie> createMovies() {
        List<Movie> movies = new ArrayList<>();

        // make movies
        Movie venomMovie = new Movie("Venom", 12.95, 2, 30);
        Movie noTimeToDieMovie = new Movie("No time to die", 11.95, 3, 10);
        Movie duneMovie = new Movie("Dune", 10.95, 1, 55);
        Movie shangChiMovie = new Movie("Shang-Chi", 14.95, 2, 45);

        // add movies and return
        movies.add(venomMovie);
        movies.add(noTimeToDieMovie);
        movies.add(duneMovie);
        movies.add(shangChiMovie);
        return movies;
    }
}
