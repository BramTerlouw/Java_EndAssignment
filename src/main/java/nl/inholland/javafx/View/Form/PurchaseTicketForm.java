package nl.inholland.javafx.View.Form;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.View.Scene.MainScene;

public class PurchaseTicketForm extends BaseForm{

    private int[] nrOfSeatValues = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public PurchaseTicketForm(MainScene main, Database db, Showing showing) {
        super(main, db);
        if (showing != null) {
            Label lblRoomAnswer = new Label(showing.getRoom().getName());
            Label lblStartAnswer = new Label(showing.getStartMovie().toString());
            Label lblEndAnswer = new Label(showing.getEndMovie().toString());
            Label lblTitleAnswer = new Label(showing.getMovieTitle());
            ComboBox<Integer> cbNrOfSeats = new ComboBox();
            for (int i:nrOfSeatValues) {
                cbNrOfSeats.getItems().add(i);
            }
            TextField txtNameAnswer = new TextField();
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

    private void handleClear(){
        this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
    }

    private void handlePurchase(Showing showing, ComboBox cbNrOfSeats, TextField txtName){
        String nameCustomer;
        int nrOfSeatsChosen = (int) cbNrOfSeats.getSelectionModel().getSelectedItem();

        if (!txtName.getText().isBlank()) {
            nameCustomer = txtName.getText();
            if (this.validatePurchase(showing, nrOfSeatsChosen)){
                this.db.reduceSeats(showing, nrOfSeatsChosen);
                main.refreshShowing();
                this.main.setForm(new BaseForm(main, db).getForm(), "Purchase tickets");
            }
        }
    }

    private boolean validatePurchase(Showing showing, int nrOfSeatsChosen){
        if (nrOfSeatsChosen <= 0)
            return false;
        else if ((showing.getNrOfSeats() - nrOfSeatsChosen) < 0)
            return false;
        else
            return true;
    }
}
