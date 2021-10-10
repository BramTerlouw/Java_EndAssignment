package nl.inholland.javafx.View.Form;

import javafx.scene.control.*;
import nl.inholland.javafx.Model.Theater.Movie;
import nl.inholland.javafx.Model.Theater.Room;
import nl.inholland.javafx.Model.Theater.Showing;

public class ManageShowingForm extends BaseForm{

    public ManageShowingForm() {
        createManageShowingForm();
    }

    public void createManageShowingForm(){
        // Form items
        ComboBox<Movie> cbMovies = new ComboBox<>();
        ComboBox<Room> cbRooms = new ComboBox<>();
        Label lblNrOfSeatsAnswer = new Label("nr of seats");
        DatePicker dpStart = new DatePicker();
        TextField txtTime = new TextField();
        Label lblEndAnswer = new Label("End time");
        Label lblPriceAnswer = new Label("price");
        Button btnAdd = new Button("Add Showing");
        Button btnClear = new Button("Clear");

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
}
