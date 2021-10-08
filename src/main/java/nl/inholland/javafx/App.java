package nl.inholland.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.inholland.javafx.View.Stage.Login;

public class App extends Application {
    @Override
    public void start(Stage window) throws Exception {
        Login loginWindow = new Login();
        loginWindow.getWindow().show();
    }

    public static void main(String[] args) {
        launch();
    }
}
