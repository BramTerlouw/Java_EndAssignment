package nl.inholland.javafx.Database;

import nl.inholland.javafx.Database.Migrations.*;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.Model.Theater.Ticket;

import java.util.List;

public class Database {

    private final List<Person> users;
    private final List<Movie> movies;
    private final List<Room> rooms;
    private final List<Showing> showings;
    private final List<Ticket> tickets;

    public Database() {
        users = new userMigration().createPersons();
        movies = new movieMigrator().createMovies();
        rooms = new roomMigrator().createRooms();
        showings = new showingMigrator().createShowings(movies, rooms);
        tickets = new ticketMigrator().createTickets(showings);
    }

    // methods for modifying data
    public void insertShowing(Showing showing) {
        showings.add(showing);
    }

    public void insertMovie(Movie movie) {
        movies.add(movie);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public int getNrOfTickets() {
        return tickets.size();
    }

    // getters
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

    public List<Ticket> getTickets() {
        return tickets;
    }
}
