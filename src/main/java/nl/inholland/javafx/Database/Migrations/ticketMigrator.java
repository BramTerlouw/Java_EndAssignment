package nl.inholland.javafx.Database.Migrations;

import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.Model.Theater.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ticketMigrator {

    public List<Ticket> createTickets(List<Showing> showings) {
        List<Ticket> tickets = new ArrayList<>();

        // make tickets
        Ticket ticket1 = new Ticket(1, "Bram", showings.get(1), 3);
        Ticket ticket2 = new Ticket(2, "Koen", showings.get(2), 5);

        // add tickets and return
        tickets.add(ticket1);
        tickets.add(ticket2);
        return tickets;
    }
}
