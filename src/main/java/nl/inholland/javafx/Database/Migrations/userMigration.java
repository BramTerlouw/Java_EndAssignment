package nl.inholland.javafx.Database.Migrations;

import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Person.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class userMigration {

    public List<Person> createPersons(){
        List<Person> users = new ArrayList<>();

        // make admin and user
        Person admin = new Person(1, "admin", "Bram", "Terlouw",
                LocalDate.of(2000, 02, 18), "bram@example.com", "password", Role.ADMIN);
        Person user = new Person(2, "user", "Mark", "de Haan",
                LocalDate.of(1990, 02, 02), "mark@example.com", "password", Role.USER);

        // add users to list and return
        users.add(admin);
        users.add(user);
        return users;
    }
}
