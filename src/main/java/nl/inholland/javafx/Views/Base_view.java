package nl.inholland.javafx.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Base_view {

    protected Stage window;

    public Base_view(){
        window = new Stage();
        window.setHeight(600);
        window.setWidth(800);
        window.setTitle("Login Screen");
    }

    protected GridPane generateGrid(){

        // Make new grid and set alignment, vertical and horizontal space and padding
        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // 1e column
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(200);
        col1.setMaxWidth(200);
        grid.getColumnConstraints().add(col1);

        // 2e column
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(200);
        grid.getColumnConstraints().add(col2);
        return grid;
    }

    public Stage getWindow() {
        return window;
    }
}
