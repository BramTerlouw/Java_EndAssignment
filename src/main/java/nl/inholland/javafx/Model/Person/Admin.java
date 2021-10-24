package nl.inholland.javafx.Model.Person;

import java.time.LocalDate;

public class Admin extends Person {

    public Admin(int id, String userName, String firstName, String lastName, LocalDate birthday, String email, String password) {
        super(id, userName, firstName, lastName, birthday, email, password);
    }
}
