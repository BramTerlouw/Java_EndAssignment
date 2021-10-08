package nl.inholland.javafx.Views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_View extends Base_view {

    private Scene mainScene;

    public Main_View(){
        // navbar
        HBox navBar = new HBox();
        navBar.setAlignment(Pos.TOP_CENTER);

        // buttons assignments
        Button openCurrencyConverter = new Button("Currency converter");
        Button openCarRental = new Button("Car rental");
        Button openTicTacToe = new Button("Tic tac toe");

        // add buttons to nav and nav to layout
        navBar.getChildren().addAll(openCurrencyConverter, openCarRental, openTicTacToe);

        // button action handle with lambda
        openCurrencyConverter.setOnAction(actionEvent -> window.setScene(new Assignment1_View().getScene()));
        openCarRental.setOnAction(actionEvent -> window.setScene(new Assignment2_View().getScene()));
        openTicTacToe.setOnAction(actionEvent -> window.setScene(new Assignment3_View().getScene()));


        mainScene = new Scene(navBar);
        window.setTitle("Main window");
        window.setScene(mainScene);
    }
}
