package nl.inholland.javafx.Database;

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
        Data data = new Data();
        users = data.createPersons();
        movies = data.createMovies();
        rooms = data.createRooms();
        showings = data.createShowings(movies, rooms);
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
