package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import seng201.team131.Player;

public class ParentScreenController extends Controller {
    private Player player;
    private boolean needsInitialization = false;

    @FXML
    private Button BtnTowerScreen;
    @FXML
    private Button BtnGameChangersScreen;
    @FXML
    private Button BtnShopScreen;
    @FXML
    private Button BtnMainScreen;
    

    public ParentScreenController(Player player) {
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        if (needsInitialization) {
            initialize();
        }
    }

    public ParentScreenController() {
        // default - for FXLoader
    }

    @FXML
    public void onBtnTowerScreen() {
        if (player != null) {
            this.player.launchTowerScreen();
        }
    }
    @FXML
    public void onBtnMainScreen() {
        // Handle Main Screen button click
    }

    @FXML
    public void onBtnGameChangersScreen() {
        if (player != null) {
            this.player.launchGameChangersScreen();
        }
    }

    @FXML
    public void onBtnShopScreen() {
        if (player != null) {
            this.player.launchShopScreen();
        }
    }
    /* 
    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();*/
    
    @FXML
    public void initialize() {
        if (player != null) {
            player.setSelected(null);
            player.launchUserPane();
        }
    }
}
