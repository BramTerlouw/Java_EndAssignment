package nl.inholland.javafx.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import nl.inholland.javafx.Assigmnents.Assignment1;
import nl.inholland.javafx.Assigmnents.Assignment2;

public class Assignment2_View extends Base_view{

    private Scene assignemt2;
    private Assignment2 assignment;
    private GridPane layout;

    public Assignment2_View(){
        assignment = new Assignment2();
        layout = generateGrid();

        // grid items
        Label lblNrOfDays = new Label("Number of days rented: ");
        TextField txtNrOfDays = new TextField();
        Label lblNrOfKMs = new Label("Number of kilometers driven: ");
        TextField txtNrOfKMs = new TextField();
        CheckBox ckbTankNotFull = new CheckBox();
        ckbTankNotFull.setText("Fuel tank not full when returned");
        Label lblNrOfLiters = new Label("Number of liters: ");
        TextField txtNrOfLiters = new TextField();
        Button btnCalcPayment = new Button("Calculate payment");
        Label lblDue = new Label("Amount: ");

        // add items to GridPane
        layout.add(lblNrOfDays, 0, 0);
        layout.add(txtNrOfDays, 1, 0);
        layout.add(lblNrOfKMs, 0, 1);
        layout.add(txtNrOfKMs, 1, 1);
        layout.add(ckbTankNotFull, 0, 2);
        layout.add(lblNrOfLiters, 0, 3);
        layout.add(txtNrOfLiters, 1, 3);
        layout.add(btnCalcPayment, 1, 4);
        layout.add(lblDue, 0, 5);

        // button event handler
        btnCalcPayment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int nrOfLiters = 0;
                int nrOfDays = Integer.parseInt(txtNrOfDays.getText());
                int kmDriven = Integer.parseInt(txtNrOfKMs.getText());
                if (ckbTankNotFull.isSelected())
                    nrOfLiters = Integer.parseInt(txtNrOfLiters.getText());
                lblDue.setText("Amount: " + String.valueOf(assignment.calculatuRent(nrOfDays, kmDriven, ckbTankNotFull.isSelected(), nrOfLiters)));
            }
        });

        assignemt2 = new Scene(layout);
        window.setTitle("Assignment2");
        window.setScene(assignemt2);
    }


    public Scene getScene(){
        return assignemt2;
    }
}
