package nl.inholland.javafx.View.Form;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class BaseForm {

    protected GridPane form;

    public BaseForm() {
        this.form = createGrid();
    }

    private GridPane createGrid() {
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setVgap(10);
        form.setHgap(25);
        form.setMinHeight(180);
        form.setMinWidth(1200);
        form.setMaxWidth(1200);
        form.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: blue;");
        return form;
    }

    public GridPane getForm() {
        return form;
    }
}

