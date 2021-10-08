package nl.inholland.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.inholland.javafx.Views.Main_View;

public class App extends Application {
    @Override
    public void start(Stage window) throws Exception {
        Main_View mainWindow = new Main_View();
        mainWindow.getWindow().show();
    }

    public static void main(String[] args) {
        launch();
    }
}
