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
                this::launchSetupScreen,
                this::launchParentScreen,
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
    ////////////////////placeholders/////////////

    private void launchEndScreen(Player player) {
    }

    private void launchShopScreen(Player player) {
    }

    private void launchTowerScreen(Player player) {
    }

    private void launchUserPane(Player player) {
    }

    ////////////////////////////////////////

    public void launchSetupScreen(Player player) {
//        backgroundController.loadColumn(0, "/fxml/setup_screen.fxml", new SetupScreenController(player));
    }

    public void launchParentScreen(Player player) {
//        backgroundController.loadColumn(1, "/fxml/parent_screen.fxml", new ParentScreenController(player));
    }

//    public void launchTowerScreen(Player player) {
//        backgroundController.loadColumn(2, "/fxml/tower_screen.fxml", new TowerScreenController(player));
//    }
//
//    public void launchShopScreen(Player player) {
//        backgroundController.loadColumn(1, "/fxml/shop_screen.fxml", new ShopScreenController(player));
//    }

    public void launchGameChangersScreen(Player player) {
//        backgroundController.loadColumn(2, "/fxml/trade_off_screen.fxml", new TradeOffScreenController(player));
    }

//    public void launchEndScreen(Player player) {
//        backgroundController.loadColumn(0, "/fxml/end_screen.fxml", new EndScreenController(player));
//    }

    public void launchMainScreen(Player player) {
//        backgroundController.loadColumn(0, "/fxml/main_screen.fxml", new MainScreenController(player));
    }

    public void clearPane() {
//        backgroundController.clearColumn(0);
//        backgroundController.clearColumn(1);
//        backgroundController.clearColumn(2);
    }
}