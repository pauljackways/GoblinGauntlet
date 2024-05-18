package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
    }
    public ParentScreenController() {
        //default - for FXLoader's perverse pleasure
    }

    @FXML
    public void onBtnTowerScreen() {
        player.closeParentScreen();
        //player.launchTowerScreen();
    
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