package nl.inholland.javafx.View.Stage;

import javafx.stage.Stage;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.View.Scene.LoginScene;

public class Login {
    private final Stage window;

    public Login(Database db) {
        this.window = new Stage();
        this.window.setWidth(400);
        this.window.setHeight(200);
        this.window.setTitle("Vue Cinema -- Login");
        this.window.setScene(new LoginScene(this.window, db).getLoginScene());
    }

    public Stage getWindow() {
        return window;
    }
}
