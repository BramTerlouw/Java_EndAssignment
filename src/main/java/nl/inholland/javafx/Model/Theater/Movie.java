package nl.inholland.javafx.Model.Theater;

import java.time.LocalTime;

public class Movie {
    private String name;
    private double ticketPrice;
    private long durationHours;
    private long durationMinutes;

    public Movie(String name, double ticketPrice, long durationHours, long durationMinutes) {
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.durationHours = durationHours;
        this.durationMinutes = durationMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public long getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(long durationHours) {
        this.durationHours = durationHours;
    }

    public long getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(long durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
