package nl.inholland.javafx.Database;

import nl.inholland.javafx.Database.Migrations.movieMigrator;
import nl.inholland.javafx.Database.Migrations.roomMigrator;
import nl.inholland.javafx.Database.Migrations.showingMigrator;
import nl.inholland.javafx.Database.Migrations.userMigration;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;
import java.util.List;
import java.util.Objects;

public class Database {

    private final List<Person> users;
    private final List<Movie> movies;
    private final List<Room> rooms;
    private final List<Showing> showings;

    public Database() {
        users = new userMigration().createPersons();
        movies = new movieMigrator().createMovies();
        rooms = new roomMigrator().createRooms();
        showings = new showingMigrator().createShowings(movies, rooms);
    }


    // methods for modifying data
    public void reduceSeats(Showing showing, int nrOfSeats){
        for (Showing s:showings) {
            if (Objects.equals(s, showing)) {
                s.setNrOfSeats(nrOfSeats);
            }
        }
    }
    public void insertShowing(Showing showing){
        showings.add(showing);
    }
    public void insertMovie(Movie movie){
        movies.add(movie);
    }


    // getters
    public List<Person> getUsers() { return users; }
    public List<Movie> getMovies() { return movies; }
    public List<Room> getRooms() {return rooms; }
    public List<Showing> getShowings() {return showings; }
}
