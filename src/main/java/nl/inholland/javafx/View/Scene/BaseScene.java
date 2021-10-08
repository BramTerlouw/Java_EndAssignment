package nl.inholland.javafx.View.Scene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import nl.inholland.javafx.Database.Database;
import nl.inholland.javafx.View.Stage.Login;
import nl.inholland.javafx.View.Stage.Main;

public class BaseScene {
    protected Database db;
    protected VBox layout;
    protected Main mainWindow;

    public BaseScene(Main mainWindow){
        db = new Database();
        layout = new VBox();
        this.mainWindow = mainWindow;

        layout.getChildren().add(this.createNavBar());
    }

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

    private void logOut(){
        new Login().getWindow().show();
        this.mainWindow.getWindow().close();
    }
}
