package nl.inholland.javafx.View.Scene;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.Model.Theater.Showing;
import nl.inholland.javafx.View.Stage.Login;
import nl.inholland.javafx.View.Stage.Main;

public class MainScene {
    private final Main main;
    private final Database db;
    private final Scene mainScene;

    private final VBox layout;
    private final VBox layoutContainer;
    private TableView roomOne;
    private TableView roomTwo;

    public MainScene(Main mainWindow) {
        this.main = mainWindow;
        this.db = new Database();

        this.layoutContainer = new VBox(createSceneHeader("Purchase tickets"), createShowingDisplay(), createFormContainer(), createFooter());
        this.layoutContainer.setPadding(new Insets(10, 10, 10, 10));
        this.layoutContainer.setAlignment(Pos.CENTER);
        this.layoutContainer.setSpacing(10);

        this.layout = new VBox(createNavBar(), layoutContainer);

        this.mainScene = new Scene(this.layout);
        mainWindow.setStageTitle("Purchase tickets");
    }



    // create navbar for scene
    private MenuBar createNavBar(){
        MenuBar navBar = new MenuBar();

        Menu adminMenu = new Menu("Admin");
        MenuItem manageShowingsItem = new MenuItem("Manage showings");
        MenuItem ManageMoviesItem = new MenuItem("Manage movies");
        adminMenu.getItems().addAll(manageShowingsItem, ManageMoviesItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);

        Menu logoutMenu = new Menu("Logout");
        MenuItem logoutItem = new MenuItem("Logout");
        logoutItem.setOnAction(actionEvent -> logOut());
        logoutMenu.getItems().add(logoutItem);

        navBar.getMenus().addAll(adminMenu, helpMenu, logoutMenu);
        return navBar;
    }



    // create header of scene
    private HBox createSceneHeader(String text){
        HBox header = new HBox();
        Label sceneHeader = new Label(text);
        header.getChildren().add(sceneHeader);
        header.setMaxWidth(1200);
        return header;
    }



    // create grid with tableviews
    private GridPane createShowingDisplay(){
        GridPane displayContainer = new GridPane();
        displayContainer.setPadding(new Insets(10));
        displayContainer.setMinHeight(400);
        displayContainer.setMinWidth(1200);
        displayContainer.setMaxWidth(1200);
        displayContainer.setHgap(10);
        displayContainer.setVgap(10);
        setGridConstraints(displayContainer, new int[] {585, 585});

        displayContainer.add(new Label("Room 1"), 0, 0);
        displayContainer.add(new Label("Room 2"), 1, 0);
        displayContainer.add(createDisplayTable("Room 1"), 0, 1);
        displayContainer.add(createDisplayTable("Room 2"), 1, 1);

        displayContainer.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: blue;");
        return displayContainer;
    }

    private void setGridConstraints(GridPane grid, int[] colWidths){
        for (int width:colWidths) {
            grid.getColumnConstraints().add(new ColumnConstraints(width));
        }
    }
    private TableView createDisplayTable(String room){
        TableView displayTable = new TableView();
        displayTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        displayTable.setMinWidth(585);
        this.createTableColumns(displayTable);
        this.fillTable(displayTable, room);

        return displayTable;
    }
    private void createTableColumns(TableView table){
        TableColumn<Showing, String> col1 = new TableColumn<>("Start");
        col1.setMinWidth(150);
        col1.setCellValueFactory(new PropertyValueFactory<>("startMovie"));

        TableColumn<Showing, String> col2 = new TableColumn<>("End");
        col2.setMinWidth(150);
        col2.setCellValueFactory(new PropertyValueFactory<>("endMovie"));

        TableColumn<Showing, String> col3 = new TableColumn<>("Title");
        col3.setMinWidth(150);
        col3.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));

        TableColumn<Showing, String> col4 = new TableColumn<>("Seats");
        col4.setMinWidth(65);
        col4.setCellValueFactory(new PropertyValueFactory<>("nrOfSeats"));

        TableColumn<Showing, String> col5 = new TableColumn<>("Price");
        col5.setMinWidth(65);
        col5.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(col1, col2, col3, col4, col5);
    }
    private void fillTable(TableView table, String room){
        ObservableList<Showing> showings = FXCollections.observableArrayList(db.getShowings());
        for (Showing showing:showings) {
            if (showing.getRoom().getName().equalsIgnoreCase(room))
                table.getItems().add(showing);
        }
    }



    // create form gridPane
    private GridPane createFormContainer(){
        GridPane formGrid = new GridPane();
        formGrid.setMinHeight(180);
        formGrid.setMinWidth(1200);
        formGrid.setMaxWidth(1200);
        formGrid.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: blue;");
        return formGrid;
    }




    // Create scene footer
    private Pane createFooter(){
        Pane pane = new Pane();
        pane.setMinHeight(50);
        pane.setMinWidth(1200);
        pane.setMaxWidth(1200);
        pane.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: blue;");
        return pane;
    }




    // Login function
    private void logOut(){
        new Login().getWindow().show();
        this.main.getWindow().close();
    }


    // -- Return the main scene
    public Scene getMainScene() {
        return mainScene;
    }
}
