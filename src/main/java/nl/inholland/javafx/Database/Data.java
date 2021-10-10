package nl.inholland.javafx.Database;

import nl.inholland.javafx.Model.Person.Admin;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Person.User;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<Person> createPersons(){
        List<Person> users = new ArrayList<>();

        // make admin and user
        Admin admin = new Admin(1, "admin", "Bram", "Terlouw",
                LocalDate.of(2000, 02, 18), "bram@example.com", "password");
        User user = new User(2, "user", "Mark", "de Haan",
                LocalDate.of(1990, 02, 02), "mark@example.com", "password");

        // add users to list and return
        users.add(admin);
        users.add(user);
        return users;
    }

    public List<Movie> createMovies(){
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

    public List<Room> createRooms(){
        List<Room> rooms = new ArrayList<>();

        // make rooms
        Room room1 = new Room("Room 1", 200);
        Room room2 = new Room("Room 2", 100);

        // add rooms and return
        rooms.add(room1);
        rooms.add(room2);
        return rooms;
    }

    public List<Showing> createShowings(List<Movie> movies, List<Room> rooms){
        List<Showing> showings = new ArrayList<>();

        // make showings
        Showing showing1 = new Showing(movies.get(1), rooms.get(0), LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 00)));
        Showing showing2 = new Showing(movies.get(2), rooms.get(0), LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 00)));
        Showing showing3 = new Showing(movies.get(3), rooms.get(0), LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 00)));
        Showing showing4 = new Showing(movies.get(0), rooms.get(1), LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 15)));

        // add showings and return
        showings.add(showing1);
        showings.add(showing2);
        showings.add(showing3);
        showings.add(showing4);
        return showings;
    }
}
