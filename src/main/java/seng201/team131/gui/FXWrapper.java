package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import seng201.team131.Player;

import java.io.IOException;

public class FXWrapper {
    @FXML
    private Pane pane;

    private Stage stage;


    public void init(Stage stage) {
        this.stage = stage;
        new Player(this::launchSetupScreen, this::launchMainScreen, this::clearPane);
    }

    public void launchSetupScreen(Player player) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new SetupScreenController(player));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Rocket Manager Setup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearPane() {
        pane.getChildren().removeAll(pane.getChildren());
    }

    public void launchMainScreen(Player player) {
        try {
            FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("/fxml/main_screen.fxml"));
            mainScreenLoader.setControllerFactory(param -> new SetupScreenController(player));
            Parent setupParent  = mainScreenLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Rocket Manager Main Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
