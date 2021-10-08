package nl.inholland.javafx.View.Scene;

import javafx.scene.Scene;
import nl.inholland.javafx.View.Stage.Main;

public class MainScene extends BaseScene{
    private final Scene mainScene;

    public MainScene(Main mainWindow) {
        super(mainWindow);
        mainScene = new Scene(this.layout);
        this.mainWindow.setStageTitle("Purchase tickets");
    }

    public Scene getMainScene() {
        return mainScene;
    }
}
