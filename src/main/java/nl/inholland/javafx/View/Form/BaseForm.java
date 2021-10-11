package nl.inholland.javafx.View.Form;

import javafx.geometry.Insets;
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

    protected void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    protected void showConfirmationMessage(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public GridPane getForm() {
        return form;
    }
}

