package nl.inholland.javafx.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import nl.inholland.javafx.Assigmnents.Assignment3;

import java.util.Random;

public class Assignment3_View extends Base_view{
    private Scene assignment3;
    private final Assignment3 assignment;
    private GridPane layout;

    public Assignment3_View(){
        layout = new GridPane();
        assignment = new Assignment3(layout);
        layout.setAlignment(Pos.CENTER);

        // column constraints
        ColumnConstraints cols = new ColumnConstraints();
        cols.setPrefWidth(100);
        cols.setMaxWidth(100);
        layout.getColumnConstraints().addAll(cols, cols, cols);


        layout = assignment.fillGrid();

        assignment3 = new Scene(layout);
        window.setTitle("Assignment3");
        window.setScene(assignment3);
    }

    public Scene getScene(){
        return assignment3;
    }
}
