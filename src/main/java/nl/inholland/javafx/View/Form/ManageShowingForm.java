package nl.inholland.javafx.View.Form;

import javafx.scene.control.*;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.View.Scene.MainScene;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ManageShowingForm extends BaseForm{

    ComboBox<String> cbMovies;
    ComboBox<String> cbRooms;
    Label lblNrOfSeatsAnswer;
    DatePicker dpStart;
    TextField txtTime;
    Label lblEndAnswer;
    Label lblPriceAnswer;

    Movie movie;
    Room room;

    public ManageShowingForm(MainScene main, Database db) {
        super(main, db);
        this.form.getStyleClass().add("custom-form");

        // labels for nr of seats, ticket price and end date (value set with listeners)
        lblNrOfSeatsAnswer = new Label();
        lblPriceAnswer = new Label();
        lblEndAnswer = new Label();


        // datepicker and text field for the start of the movie
        dpStart = new DatePicker();
        dpStart.setMaxWidth(135);
        dpStart.setValue(LocalDate.now());

        txtTime = new TextField();
        txtTime.setText("20:00");


        // combo boxes for all movies and rooms
        cbMovies = new ComboBox<>();
        cbRooms = new ComboBox<>();
        cbMovies.setMinWidth(145);
        cbRooms.setMinWidth(145);
        for (Movie m: db.getMovies()) { cbMovies.getItems().add(m.getName()); }
        for (Room r: db.getRooms()) { cbRooms.getItems().add(r.getName()); }
        this.setFormListeners();

        cbMovies.getSelectionModel().selectFirst();
        cbRooms.getSelectionModel().selectFirst();


        // buttons for adding a showing and clearing the form
        Button btnAdd = new Button("Add Showing");
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(actionEvent -> handleClear());
        btnAdd.setOnAction(actionEvent -> handleAdd());

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

    // set listeners on the combo boxes, text field and date picker
    private void setFormListeners(){
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
                    .ifPresent(r -> {
                        lblNrOfSeatsAnswer.setText(String.valueOf(r.getNrOfSeats()));
                        room = r;
                    });

        });
        txtTime.textProperty().addListener((observable, oldValue, newValue) -> {
            endDateListenEvent();
        });
        dpStart.valueProperty().addListener((observable, oldValue, newValue) -> {
            endDateListenEvent();
        });
    }

    // handle clear button pressed action event
    private void handleClear(){
        setOriginalHeaderScene();
        this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
    }

    // handle add button pressed action event
    private void handleAdd(){
        if (validateInputRegex(true) && validateNewShowingDateTime()) {
            setOriginalHeaderScene();
            db.insertShowing(new Showing(this.movie, this.room, this.getStartMovie()));
            showConfirmationMessage("Confirmation new showing.", "The new showing is added to the agenda!");
            main.refreshShowing();
            this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
        }
    }


    // get start time of movie
    private LocalDateTime getStartMovie(){
        LocalDate startDateMovie = dpStart.getValue();

        String[] splitInput = txtTime.getText().split(":");
        LocalTime startTimeMovie = LocalTime.of(Integer.parseInt((splitInput[0])), Integer.parseInt((splitInput[1])));
        return LocalDateTime.of(startDateMovie, startTimeMovie);
    }

    // get end time of movie
    private String getEndMovie(LocalDateTime movieDate, long hours, long minutes){
        LocalDateTime end = movieDate.plusHours(hours);
        end = end.plusMinutes(minutes);
        return end.toString();
    }




    // method is called in the listener
    private void endDateListenEvent(){
        if (validateInputRegex(false))
            lblEndAnswer.setText(this.getEndMovie(this.getStartMovie(), movie.getDurationHours(), movie.getDurationMinutes()));
    }





    // Validate the datetime of new and planned showings
    private boolean validateNewShowingDateTime(){
        List<Showing> showings = db.getShowings();
        for (Showing showing:showings) {
            if (showing.getRoom().equals(room))
                if (isOverlapping(
                        getStartMovie(),                            // start new showing
                        LocalDateTime.parse(lblEndAnswer.getText()),// end new showing
                        showing.getStartMovie().minusMinutes(15),   // start planned showing minus 15 min
                        showing.getEndMovie().plusMinutes(15)))     // end planned showing plus 15 min
                {
                    showErrorMessage("New showing is overlapping with another showing!");
                    return false;
                }
        }
        return true;
    }

    // if showings overlap, return true
    private boolean isOverlapping(LocalDateTime startNewShowing, LocalDateTime endNewShowing,
                                  LocalDateTime startOldShowing, LocalDateTime endOldShowing){
        // return true if start new showing not after end old showing && start old showing not after end new showing
        return !startNewShowing.isAfter(endOldShowing) && !startOldShowing.isAfter(endNewShowing);
    }

    // validate user input values
    private boolean validateInputRegex(boolean showError){
        if (!txtTime.getText().matches("\\d{2}:\\d{2}")){
            if (showError)
                showErrorMessage("Make sure you use the correct time format! (hh:mm)");
            return false;
        }

        String[] startTime = txtTime.getText().split(":");
        if (Integer.parseInt(startTime[0]) > 23 || Integer.parseInt(startTime[1]) > 59){
            if (showError)
                showErrorMessage("Make sure you use correct values for hours (00 - 23) and minutes (00 - 59)");
            return false;
        }
        return true;
    }
}