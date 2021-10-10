package nl.inholland.javafx.View.Scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nl.inholland.javafx.Model.Person.User;
import nl.inholland.javafx.View.Stage.Main;

import java.time.LocalDate;

public class LoginScene {
    private GridPane layout;
    private final Stage login;
    private final Scene loginScene;

    public LoginScene(Stage login) {
        this.login = login;
        this.layout = createLogin();
        this.loginScene = new Scene(layout);
    }

    private GridPane createLogin(){
        GridPane loginGrid = new GridPane();
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.setVgap(10);
        loginGrid.setHgap(25);

        Label lblUserName = new Label("Username");
        Label lblPassword = new Label("password");

        TextField txtUserName = new TextField();
        txtUserName.setPromptText("Enter Username...");

        PasswordField pwPassword = new PasswordField();
        pwPassword.setPromptText("Enter Password...");

        Button btnLogin = new Button("Log in");
        btnLogin.setOnAction(actionEvent -> handleLogin());

        loginGrid.add(lblUserName, 0, 0);
        loginGrid.add(lblPassword, 0, 1);
        loginGrid.add(txtUserName, 1, 0);
        loginGrid.add(pwPassword, 1, 1);
        loginGrid.add(btnLogin, 0, 2);

        return loginGrid;
    }

    private void handleLogin(){
        User temporary = new User(1, "test", "test", "test",
                LocalDate.of(2000, 02, 18), "test", "test");
        new Main(temporary).getWindow().show();
        this.login.close();
    }

    public Scene getLoginScene() {
        return loginScene;
    }
}
