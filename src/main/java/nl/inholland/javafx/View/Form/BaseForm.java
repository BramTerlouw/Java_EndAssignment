package nl.inholland.javafx.View.Form;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.View.Scene.MainScene;

import javax.swing.*;

public class BaseForm {

    protected GridPane form;
    protected MainScene main;
    protected Database db;

    public BaseForm(MainScene main, Database db) {
        this.form = createGrid();
        this.main = main;
        this.db = db;
    }

    // create and return form grid
    private GridPane createGrid() {
        GridPane form = new GridPane();
        form.getStyleClass().add("custom-empty-form");
        form.setPadding(new Insets(10));
        form.setVgap(10);
        form.setHgap(5);
        form.setMinHeight(150);
        form.setMinWidth(1200);
        form.setMaxWidth(1200);
        setColConstraint(form, new int[]{145, 145, 145, 60, 70, 480}); // column widths
        return form;
    }

    private void setColConstraint(GridPane form, int[] colWidths) {
        for (int width : colWidths) {
            ColumnConstraints colConstraint = new ColumnConstraints();
            colConstraint.setMinWidth(width);
            form.getColumnConstraints().add(colConstraint);
        }
    }

    // show error message
    protected void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // show confirmation message
    protected void showConfirmationMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // set scene header to default header message
    protected void setOriginalHeaderScene() {
        this.main.setSceneHeader("Purchase tickets");
    }

    // return form
    public GridPane getForm() {
        return form;
    }
}

