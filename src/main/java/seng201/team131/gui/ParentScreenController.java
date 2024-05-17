package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team131.Player;

public class ParentScreenController {
    private Player player;

    @FXML
    private Button BtnTowerScreen;
    @FXML
    private Button BtnGameChangersScreen;
    @FXML
    private Button BtnShopScreen;
    @FXML
    private Button BtnMainScreen;

    public ParentScreenController(Player thePlayer) {
        player = thePlayer;
    }
    public void setPlayer(Player player) {
        // Method implementation
    }
    public ParentScreenController() {
        //default - for FXLoader's perverse pleasure
    }

    @FXML
    public void onBtnTowerScreen() {
        // Handle Tower Screen button click
    }

    @FXML
    public void onBtnMainScreen() {
        // Handle Main Screen button click
    }

    @FXML
    public void onBtnGameChangersScreen() {
        player.launchGameChangersScreen();
    }

    @FXML
    public void onBtnShopScreen() {
        player.launchShopScreen();
    }

    @FXML
    public void initialize() {
        // Initialize controller
    }
}