package nl.inholland.javafx.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import nl.inholland.javafx.Assigmnents.Assignment1;

public class Assignment1_View extends Base_view{

    private Scene assignemt1;
    private Assignment1 assignment;
    private GridPane layout;

    public Assignment1_View(){
        assignment = new Assignment1();
        layout = generateGrid();

        Label amountEuro = new Label("Amount \u20ac: ");
        TextField amountEuroText = new TextField();

        Button btnConvert = new Button("Convert Euro to Dollar");
        Label amountDollar = new Label("Amount $: ");

        layout.add(amountEuro, 0, 0);
        layout.add(amountEuroText, 1, 0);
        layout.add(btnConvert, 1, 1);
        layout.add(amountDollar, 0, 2);

        btnConvert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double output = assignment.calculateCurrency(Double.parseDouble(amountEuroText.getText()));
                amountDollar.setText("Amount $: " + String.valueOf(output));
            }
        });

        assignemt1 = new Scene(layout);
        window.setTitle("Assignment1");
        window.setScene(assignemt1);
    }

    // return this scene
    public Scene getScene(){
        return assignemt1;
    }
}
