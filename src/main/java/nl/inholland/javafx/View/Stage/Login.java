package nl.inholland.javafx.View.Stage;

import javafx.stage.Stage;
import nl.inholland.javafx.View.Scene.LoginScene;

public class Login {
    private final Stage window;

    public Login() {
        this.window = new Stage();
        this.window.setWidth(400);
        this.window.setHeight(200);
        this.window.setTitle("Vue Cinema -- Login");
        this.window.setScene(new LoginScene(this.window).getLoginScene());
    }

    public Stage getWindow() {
        return window;
    }
}
