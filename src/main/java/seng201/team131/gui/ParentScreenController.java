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

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }

    public ParentScreenController() {
        // default - for FXLoader
    }

    @FXML
    public void onBtnTowerScreen() {
        if (player != null) {
            player.setfParent(false);
            this.player.launchTowerScreen();
        }
    }
    @FXML
    public void onBtnMainScreen() {
        player.setfParent(false);
        
    }

    @FXML
    public void onBtnGameChangersScreen() {
        if (player != null) {
            player.setfParent(false);
            this.player.launchGameChangersScreen();
        }
    }

    @FXML
    public void onBtnShopScreen() {
        if (player != null) {
            player.setfParent(false);
            this.player.launchShopScreen();
        }
    }
    @FXML
    public void initialize() {
        if (player != null) {
            player.setfParent(true);
            player.setSelected(null);
            player.launchUserPane();
        }
    }
}
