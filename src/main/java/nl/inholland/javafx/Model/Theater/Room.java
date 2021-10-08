package nl.inholland.javafx.Model.Theater;

import java.util.List;

public class Room {
    private String name;
    private int nrOfSeats;
    private List<Showing> showings;

    public Room(String name, int nrOfSeats) {
        this.name = name;
        this.nrOfSeats = nrOfSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public List<Showing> getShowings() {
        return showings;
    }

    public void setShowings(List<Showing> showings) {
        this.showings = showings;
    }
}
