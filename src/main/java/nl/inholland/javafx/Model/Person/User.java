package nl.inholland.javafx.Model.Person;

import java.time.LocalDate;

public class User extends Person{

    public User(int id, String userName, String firstName, String lastName, LocalDate birthday, String email, String password) {
        super(id, userName, firstName, lastName, birthday, email, password);
    }
}
