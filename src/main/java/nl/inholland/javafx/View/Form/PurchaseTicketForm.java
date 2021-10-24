package nl.inholland.javafx.View.Form;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.Model.Theater.Ticket;
import nl.inholland.javafx.View.Scene.MainScene;


public class PurchaseTicketForm extends BaseForm {

    public PurchaseTicketForm(MainScene main, Database db, Showing showing) {
        super(main, db);
        this.form.getStyleClass().add("custom-form");

        if (showing != null) {
            Label lblRoomAnswer = new Label(showing.getRoom().getName());
            Label lblStartAnswer = new Label(showing.getStartMovie().toString());
            Label lblEndAnswer = new Label(showing.getEndMovie().toString());
            Label lblTitleAnswer = new Label(showing.getMovieTitle());
            ComboBox<Integer> cbNrOfSeats = new ComboBox();
            cbNrOfSeats.setMinWidth(130);
            for (int i = 1; i < 16; i++) {
                cbNrOfSeats.getItems().add(i);
            }
            cbNrOfSeats.getSelectionModel().selectFirst();
            TextField txtNameAnswer = new TextField();
            txtNameAnswer.setMaxWidth(130);
            Button btnPurchase = new Button("Purchase");
            Button btnClear = new Button("Clear");
            btnClear.setOnAction(actionEvent -> handleClear());
            btnPurchase.setOnAction(actionEvent -> handlePurchase(showing, cbNrOfSeats, txtNameAnswer));

            form.add(new Label("Room:"), 0, 0);
            form.add(new Label("Start:"), 0, 1);
            form.add(new Label("End:"), 0, 2);
            form.add(new Label("Movie title:"), 2, 0);
            form.add(new Label("No. of seats:"), 2, 1);
            form.add(new Label("Name:"), 2, 2);

            form.add(lblRoomAnswer, 1, 0);
            form.add(lblStartAnswer, 1, 1);
            form.add(lblEndAnswer, 1, 2);
            form.add(lblTitleAnswer, 3, 0);
            form.add(cbNrOfSeats, 3, 1);
            form.add(txtNameAnswer, 3, 2);

            form.add(btnPurchase, 0, 4);
            form.add(btnClear, 1, 4);
        }
    }

    private void handleClear() {
        this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
    }

    private void handlePurchase(Showing showing, ComboBox cbNrOfSeats, TextField txtName) {
        String nameCustomer;
        int nrOfSeatsChosen = (int) cbNrOfSeats.getSelectionModel().getSelectedItem();

        if (!txtName.getText().isBlank()) {
            nameCustomer = txtName.getText();
            if (this.validatePurchase(showing, nrOfSeatsChosen)) {
                this.db.addTicket(new Ticket(db.getNrOfTickets() + 1, nameCustomer, showing, nrOfSeatsChosen));
                showConfirmationMessage("Purchase for " + nameCustomer + " was approved!",
                        "Purchase confirmation");
                main.refreshShowing();
                this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
            } else
                showErrorMessage("Not enough seats available!");
        } else
            showErrorMessage("All fields have te be filled!");
    }

    private boolean validatePurchase(Showing showing, int nrOfSeatsChosen) {
        if (nrOfSeatsChosen <= 0)
            return false;
        else if ((showing.getNrOfSeats() - nrOfSeatsChosen) < 0)
            return false;
        else
            return true;
    }
}
