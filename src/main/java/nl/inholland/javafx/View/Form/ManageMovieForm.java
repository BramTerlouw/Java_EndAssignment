package nl.inholland.javafx.View.Form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.View.Scene.MainScene;

public class ManageMovieForm extends BaseForm{

    private TextField txtMovie;
    private TextField txtPrice;
    private TextField txtHours;
    private TextField txtMinutes;

    public ManageMovieForm(MainScene main, Database db) {
        super(main, db);
        createManageMoviesForm();
    }

    private void createManageMoviesForm(){
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
        form.add(createMovieList(), 3, 0, 1, 3);
    }

    private void handleClear(){
        this.main.setForm(new BaseForm(main, db).getForm());
    }

    private void handleAdd(){
        db.insertMovie(new Movie(txtMovie.getText(), Double.parseDouble(txtPrice.getText()),
                Long.parseLong(txtHours.getText()), Long.parseLong(txtMinutes.getText())));
        this.main.setForm(new BaseForm(main, db).getForm());
    }


    private TableView createMovieList(){
        TableView movies = new TableView();
        movies.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        movies.setMaxHeight(100);
        this.createTableColumns(movies);
        this.fillTable(movies);
        return movies;
    }
    private void createTableColumns(TableView table){
        TableColumn<Showing, String> col1 = new TableColumn<>("Movie Name");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Showing, String> col2 = new TableColumn<>("Price");
        col2.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

        TableColumn<Showing, String> col3 = new TableColumn<>("Hours");
        col3.setCellValueFactory(new PropertyValueFactory<>("durationHours"));

        TableColumn<Showing, String> col4 = new TableColumn<>("Minutes");
        col4.setCellValueFactory(new PropertyValueFactory<>("durationMinutes"));

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
