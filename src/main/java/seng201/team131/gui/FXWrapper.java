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
        new Player(
                this::launchBackground,
                this::launchUserPane,
                this::launchSetupScreen,
                this::launchParentScreen,
                this::launchInfoPane,
                this::launchTowerScreen,
                this::launchShopScreen,
                this::launchGameChangersScreen,
                this::launchMainScreen,
                this::launchEndScreen,
                this::clearPane
        );
    }

    public void launchBackground(Player player) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/background.fxml"));
            loader.setControllerFactory(param -> new BackgroundController(player));
            Parent background = loader.load();
            pane.getChildren().add(background);
            stage.setTitle("Goblin Gauntlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void launchEndScreen(Player player) {
    }
    private void launchShopScreen(Player player) {
    }
    private void launchTowerScreen(Player player) {
    }
    private void launchUserPane(Player player) {
    }
    public void launchSetupScreen(Player player) {
    }
    public void launchParentScreen(Player player) {
    }
    private void launchInfoPane(Player player) {
    }
    public void launchGameChangersScreen(Player player) {
    }
    public void launchMainScreen(Player player) {
    }
    public void clearPane() {

    }
}