package nl.inholland.javafx.View.Stage;

import javafx.stage.Stage;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.View.Scene.MainScene;

public class Main {
    private final Stage window;
    private final Person user;

    public Main(Person user, Database db) {
        this.window = new Stage();
        this.user = user;
        this.window.setMinWidth(1210);
        this.window.setScene(new MainScene(this, db).getMainScene());
    }

    public void setStageTitle(String title){
        // set the title of the window -> display logged-in user
        this.window.setTitle("Vue Cinema -- " + title + " -- Username: " + user.getFirstName());
    }

    public Stage getWindow() {
        return window;
    }

    public Person getUser() {
        return user;
    }
}
