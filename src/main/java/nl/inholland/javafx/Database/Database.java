package nl.inholland.javafx.Database;

import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;
import java.util.List;

public class Database {

    private final List<Person> users;
    private final List<Movie> movies;
    private final List<Room> rooms;
    private final List<Showing> showings;

    public Database() {
        Data data = new Data();
        users = data.createPersons();
        movies = data.createMovies();
        rooms = data.createRooms();
        showings = data.createShowings(movies, rooms);
    }

    public List<Person> getUsers() {
        return users;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Showing> getShowings() {
        return showings;
    }
}
