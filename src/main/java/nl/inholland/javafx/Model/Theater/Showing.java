package nl.inholland.javafx.Model.Theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private Room room;
    private int nrOfSeats;
    private LocalDateTime startMovie;
    private LocalDateTime endMovie;
    private double price;

    public Showing(Movie movie, Room room, LocalDateTime startMovie) {
        this.movie = movie;
        this.room = room;
        this.nrOfSeats = room.getNrOfSeats();
        this.startMovie = startMovie;
        this.endMovie = startMovie.plusHours(movie.getDurationHours());
        this.endMovie.plusMinutes(movie.getDurationMinutes());
        this.price = movie.getTicketPrice();
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public LocalDateTime getStartMovie() {
        return startMovie;
    }

    public LocalDateTime getEndMovie() {
        return endMovie;
    }

    public double getPrice() {
        return price;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStartMovie(LocalDateTime startMovie) {
        this.startMovie = startMovie;
    }
}
