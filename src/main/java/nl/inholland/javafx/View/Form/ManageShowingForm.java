package nl.inholland.javafx.View.Form;

import javafx.scene.control.*;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.View.Scene.MainScene;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ManageShowingForm extends BaseForm{

    ComboBox<String> cbMovies;
    ComboBox<String> cbRooms;
    Label lblNrOfSeatsAnswer;
    DatePicker dpStart;
    TextField txtTime;
    Label lblEndAnswer;
    Label lblPriceAnswer;

    Movie movie;

    public ManageShowingForm(MainScene main, Database db) {
        super(main, db);
        createManageShowingForm();
    }

    public void createManageShowingForm(){
        // labels values are set by listeners of the comboBoxes
        lblNrOfSeatsAnswer = new Label();
        lblPriceAnswer = new Label();
        lblEndAnswer = new Label();







        // datepicker and text field for the start of the move
        dpStart = new DatePicker();
        dpStart.setValue(LocalDate.now());

        txtTime = new TextField();
        txtTime.setText("20:00");














        cbMovies = new ComboBox<>();
        cbRooms = new ComboBox<>();
        for (Movie m: db.getMovies()) { cbMovies.getItems().add(m.getName()); }
        for (Room r: db.getRooms()) { cbRooms.getItems().add(r.getName()); }

        cbMovies.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            db.getMovies().stream().filter(movie -> cbMovies.getValue().equalsIgnoreCase(movie.getName())).findAny()
                    .ifPresent(m -> {
                        lblPriceAnswer.setText(String.valueOf(m.getTicketPrice()));
                        movie = m;
                        endDateListenEvent();
                    });
        });
        cbRooms.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            db.getRooms().stream().filter(room -> cbRooms.getValue().equalsIgnoreCase(room.getName())).findAny()
                    .ifPresent(r -> lblNrOfSeatsAnswer.setText(String.valueOf(r.getNrOfSeats())));

        });
        txtTime.textProperty().addListener((observable, oldValue, newValue) -> {
            endDateListenEvent();
        });
        dpStart.valueProperty().addListener((observable, oldValue, newValue) -> {
            endDateListenEvent();
        });

        cbMovies.getSelectionModel().selectFirst();
        cbRooms.getSelectionModel().selectFirst();















        // buttons for adding a showing and clearing the form
        Button btnAdd = new Button("Add Showing");
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(actionEvent -> handleClear());
        //btnAdd.setOnAction(actionEvent -> handleAdd());

        form.add(new Label("Movie title:"), 0, 0);
        form.add(new Label("Room:"), 0, 1);
        form.add(new Label("No. of seats:"), 0, 2);
        form.add(new Label("Start:"), 2, 0);
        form.add(new Label("End:"), 2, 1);
        form.add(new Label("Price:"), 2, 2);

        form.add(cbMovies, 1, 0);
        form.add(cbRooms, 1, 1);
        form.add(lblNrOfSeatsAnswer, 1, 2);
        form.add(dpStart, 3, 0);
        form.add(txtTime, 4, 0);
        form.add(lblEndAnswer, 3, 1);
        form.add(lblPriceAnswer, 3, 2);
        form.add(btnAdd, 0, 4);
        form.add(btnClear, 1, 4);
    }

    private void handleClear(){
        this.main.setForm(new BaseForm(main, db).getForm());
    }

//    private void handleAdd(){
//        String movieTitle = cbMovies.getValue();
//        String room = cbRooms.getValue();
//        int nrOfSeats = Integer.parseInt(lblNrOfSeatsAnswer.getText());
//        LocalDateTime startMovie = this.validateDateTimeInput();
//
//
//        LocalDateTime endMovie = startMovie.plusHours(cbMovies.getValue().getDurationHours());
//        endMovie = endMovie.plusMinutes(cbMovies.getValue().getDurationMinutes());
//        String price = String.valueOf(cbMovies.getValue().getTicketPrice());
//
//        System.out.println(movieTitle);
//        System.out.println(room);
//        System.out.println(nrOfSeats);
//        System.out.println(startMovie);
//        System.out.println(endMovie);
//        System.out.println(price);
//    }

    private LocalDateTime getStartMove(){
        LocalDate startDateMovie = dpStart.getValue();

        String[] splitInput = txtTime.getText().split(":");
        LocalTime startTimeMovie = LocalTime.of(Integer.parseInt((splitInput[0])), Integer.parseInt((splitInput[1])));
        return LocalDateTime.of(startDateMovie, startTimeMovie);
    }

    private String calculateEndMovie(LocalDateTime movieDate, long hours, long minutes){
        LocalDateTime end = movieDate.plusHours(hours);
        end = end.plusMinutes(minutes);
        return end.toString();
    }

    private void endDateListenEvent(){
        if (txtTime.getText().matches("\\d{2}:\\d{2}"))
            lblEndAnswer.setText(this.calculateEndMovie(this.getStartMove(), movie.getDurationHours(), movie.getDurationMinutes()));
    }
}
