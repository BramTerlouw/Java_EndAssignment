package nl.inholland.javafx.Model.Theater;

public class Ticket {
    private int id;
    private String buyerName;
    private String movieName;
    private int nrOfSeats;
    private double totalPrice;

    public Ticket(int id, String buyerName, Showing showing, int nrOfSeats) {
        this.id = id;
        this.buyerName = buyerName;
        this.movieName = showing.getMovieTitle();
        this.nrOfSeats = nrOfSeats;
        this.totalPrice = this.nrOfSeats * showing.getPrice();
        showing.setNrOfSeats(nrOfSeats);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}


