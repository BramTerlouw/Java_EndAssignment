package nl.inholland.javafx.Model.Theater;

import java.time.LocalDateTime;

public class Showing {
    private String movieTitle;
    private Room room;
    private int nrOfSeats;
    private LocalDateTime startMovie;
    private LocalDateTime endMovie;
    private double price;

    public Showing(Movie movie, Room room, LocalDateTime startMovie) {
        this.movieTitle = movie.getName();
        this.room = room;
        this.nrOfSeats = room.getNrOfSeats();
        this.startMovie = startMovie;
        this.endMovie = startMovie.plusHours(movie.getDurationHours());
        this.endMovie.plusMinutes(movie.getDurationMinutes());
        this.price = movie.getTicketPrice();
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public LocalDateTime getStartMovie() {
        return startMovie;
    }

    public void setStartMovie(LocalDateTime startMovie) {
        this.startMovie = startMovie;
    }

    public LocalDateTime getEndMovie() {
        return endMovie;
    }

    public void setEndMovie(LocalDateTime endMovie) {
        this.endMovie = endMovie;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
