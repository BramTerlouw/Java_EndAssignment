package nl.inholland.javafx.View.Form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.View.Scene.MainScene;

import java.util.regex.Pattern;

public class ManageMovieForm extends BaseForm{

    private TextField txtMovie;
    private TextField txtPrice;
    private TextField txtHours;
    private TextField txtMinutes;

    public ManageMovieForm(MainScene main, Database db) {
        super(main, db);
        this.form.getStyleClass().add("custom-form");

        txtMovie = new TextField();
        txtMovie.setPromptText("Movie title...");
        txtPrice = new TextField();
        txtPrice.setPromptText("Price...");
        txtHours = new TextField();
        txtHours.setPromptText("Hours...");
        txtMinutes = new TextField();
        txtMinutes.setPromptText("Minutes...");

        Button btnAdd = new Button("Add movie");
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(actionEvent -> handleClear());
        btnAdd.setOnAction(actionEvent -> handleAdd());

        form.add(new Label("Movie title:"), 0, 0);
        form.add(new Label("Price:"), 0, 1);
        form.add(new Label("Duration:"), 0, 2);

        form.add(txtMovie, 1, 0);
        form.add(txtPrice, 1, 1);
        form.add(txtHours, 1, 2);
        form.add(txtMinutes, 2, 2);
        form.add(btnAdd, 0, 4);
        form.add(btnClear, 1, 4);
        form.add(createMovieList(), 5, 0, 1, 3);
    }

    private void handleClear(){
        this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
    }

    private void handleAdd(){
        if (validateUserInput() && validateUserRegex()) {
            db.insertMovie(new Movie(txtMovie.getText(), Double.parseDouble(txtPrice.getText()),
                    Long.parseLong(txtHours.getText()), Long.parseLong(txtMinutes.getText())));
            this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
        }
    }

    private boolean validateUserRegex(){
        String decimalPattern = "([0-9]*)\\.([0-9]*)";
        if (!Pattern.matches(decimalPattern, txtPrice.getText())){
            showErrorMessage("Wrong value for price!");
            return false;
        }
        else if (!txtHours.getText().matches("[0-9]*")){
            showErrorMessage("Wrong value for hours!");
            return false;
        }
        else if (!txtMinutes.getText().matches("[0-9]*") || Integer.parseInt(txtMinutes.getText()) > 59){
            showErrorMessage("Wrong value for minutes!");
            return false;
        }
        else
            return true;
    }

    private boolean validateUserInput(){
        if (txtMovie.getText().isEmpty() || txtPrice.getText().isEmpty() || txtHours.getText().isEmpty() ||
                txtMinutes.getText().isEmpty()){
            showErrorMessage("Not all fields are filled!");
            return false;
        }
        return true;
    }


    private TableView createMovieList(){
        TableView movies = new TableView();
        movies.getStyleClass().add("movies-table");
        movies.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        movies.setMaxHeight(125);
        movies.setMinWidth(500);
        this.createTableColumns(movies);
        this.fillTable(movies);
        return movies;
    }
    private void createTableColumns(TableView table){
        TableColumn<Showing, String> col1 = new TableColumn<>("Movie Name");
        col1.setMinWidth(140);
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Showing, String> col2 = new TableColumn<>("Price");
        col2.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
        col2.setMinWidth(140);

        TableColumn<Showing, String> col3 = new TableColumn<>("Hours");
        col3.setCellValueFactory(new PropertyValueFactory<>("durationHours"));
        col3.setMinWidth(100);

        TableColumn<Showing, String> col4 = new TableColumn<>("Minutes");
        col4.setCellValueFactory(new PropertyValueFactory<>("durationMinutes"));
        col4.setMinWidth(100);

        table.getColumns().addAll(col1, col2, col3, col4);
    }
    private void fillTable(TableView table){
        Database db = new Database();
        ObservableList<Movie> showings = FXCollections.observableArrayList(db.getMovies());
        for (Movie movie:showings) {
            table.getItems().add(movie);
        }
    }
}
