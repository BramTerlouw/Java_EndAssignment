package nl.inholland.javafx.View.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.View.Stage.Login;
import nl.inholland.javafx.View.Stage.Main;

public class BaseScene {
//    protected Database db;
//    protected VBox layout;
//    protected GridPane formContainer;
//    protected Main mainWindow;
//
//    public BaseScene(Main mainWindow){
//        this.db = new Database();
//        this.layout = new VBox();
//        this.formContainer = this.createFormContainer();
//        this.mainWindow = mainWindow;
//
//        this.layout.setAlignment(Pos.TOP_CENTER);
//        this.layout.getChildren().add(this.createNavBar());
//    }
//
//    private MenuBar createNavBar(){
//        MenuBar navBar = new MenuBar();
//
//        Menu adminMenu = new Menu("Admin");
//        MenuItem manageShowingsItem = new MenuItem("Manage showings");
//        MenuItem ManageMoviesItem = new MenuItem("Manage movies");
//        adminMenu.getItems().addAll(manageShowingsItem, ManageMoviesItem);
//
//        Menu helpMenu = new Menu("Help");
//        MenuItem aboutItem = new MenuItem("About");
//        helpMenu.getItems().add(aboutItem);
//
//        Menu logoutMenu = new Menu("Logout");
//        MenuItem logoutItem = new MenuItem("Logout");
//        logoutItem.setOnAction(actionEvent -> logOut());
//        logoutMenu.getItems().add(logoutItem);
//
//        navBar.getMenus().addAll(adminMenu, helpMenu, logoutMenu);
//        return navBar;
//    }
//
//    protected GridPane createFormContainer(){
//        GridPane formGrid = new GridPane();
//        formGrid.setMinSize(200, 1280);
//        formGrid.setStyle(
//                "-fx-border-style: solid inside;" +
//                        "-fx-border-width: 1;" +
//                        "-fx-border-color: blue;");
//        return formGrid;
//    }
//
//    protected HBox createSceneHeader(String text){
//        HBox header = new HBox();
//        //header.setMaxWidth(1000);
//        header.setPadding(new Insets(15, 10, 15, 5));
//        Label sceneHeader = new Label(text);
//        header.getChildren().add(sceneHeader);
//        return header;
//    }
//
//    private void logOut(){
//        new Login().getWindow().show();
//        this.mainWindow.getWindow().close();
//    }
}
