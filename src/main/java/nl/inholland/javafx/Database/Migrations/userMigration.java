package nl.inholland.javafx.Database.Migrations;

import nl.inholland.javafx.Model.Person.Admin;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Person.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class userMigration {

    public List<Person> createPersons() {
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
}