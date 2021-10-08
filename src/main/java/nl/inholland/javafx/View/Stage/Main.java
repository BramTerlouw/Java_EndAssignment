package nl.inholland.javafx.View.Stage;

import javafx.stage.Stage;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.View.Scene.MainScene;

public class Main {
    private final Stage window;
    private final Person user;

    public Main(Person user) {
        this.window = new Stage();
        this.user = user;
        this.window.setWidth(1000);
        this.window.setHeight(700);
        this.window.setScene(new MainScene(this).getMainScene());
    }

    public void setStageTitle(String title){
        this.window.setTitle("Vue Cinema -- " + title + " -- Username: " + user.getFirstName());
    }

    public Stage getWindow() {
        return window;
    }

    public Person getUser() {
        return user;
    }
}
