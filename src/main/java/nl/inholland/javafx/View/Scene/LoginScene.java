package nl.inholland.javafx.View.Scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.Model.Person.Role;
import nl.inholland.javafx.View.Stage.Main;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

public class LoginScene {
    private Database db;
    private GridPane layout;
    private final Stage login;
    private final Scene loginScene;

    private TextField txtUserName;
    private PasswordField pwPassword;

    public LoginScene(Stage login) {
        this.login = login;
        this.db = new Database();
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

        txtUserName = new TextField();
        txtUserName.setPromptText("Enter Username...");

        pwPassword = new PasswordField();
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
        Person person = null;
        for (Person p:db.getUsers()) {
            if (p.getUserName().equalsIgnoreCase(txtUserName.getText())
                    && Objects.equals(p.getPassword(), pwPassword.getText()))
            {
                person = p;
                break;
            }
        }
        if (person == null)
            JOptionPane.showMessageDialog(null, "Wrong credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            new Main(person).getWindow().show();
            this.login.close();
        }
    }

    public Scene getLoginScene() {
        return loginScene;
    }
}
