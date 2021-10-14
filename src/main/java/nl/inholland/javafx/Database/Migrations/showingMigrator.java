package nl.inholland.javafx.Database.Migrations;

import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class showingMigrator {

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
