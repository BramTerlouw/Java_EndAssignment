package nl.inholland.javafx.View.Scene;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.javafx.Model.Person.Person;
import nl.inholland.javafx.View.Stage.Main;

public class MainScene extends BaseScene{
    private final Scene mainScene;

    public MainScene(Main mainWindow) {
        super(mainWindow);

        layout.getChildren().addAll(createSceneHeader("Purchase tickets"), createShowDisplay());

        this.mainScene = new Scene(this.layout);
        mainWindow.setStageTitle("Purchase tickets");
    }




    private HBox createShowDisplay(){
        HBox displayContainer = new HBox();
        displayContainer.setMinHeight(400);
        displayContainer.setMaxWidth(980);
        displayContainer.setSpacing(5);
        displayContainer.setPadding(new Insets(5, 5, 5, 5));
        displayContainer.setStyle(
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-color: blue;");

        VBox leftDisplay = createDisplayItem("Room 1");
        VBox rightDisplay = createDisplayItem("Room 2");
        displayContainer.getChildren().addAll(leftDisplay, rightDisplay);

        return displayContainer;
    }



    private VBox createDisplayItem(String title){
        VBox displayItem = new VBox(new Label(title));

        TableView displayTable = new TableView();
        displayItem.setMinWidth(485);

        TableColumn<Person, String> col1 = new TableColumn<>("First Name");
        displayTable.getColumns().addAll(col1, col1, col1, col1, col1);

        displayItem.getChildren().add(displayTable);
        return displayItem;
    }




    public Scene getMainScene() {
        return mainScene;
    }
}
