package seng201.team131.gui;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team131.Player;
/**
 * Just a bunch of functions that run when buttons are click, these function chnage screens.
 */
public class ParentScreenController extends Controller {
    private Player player;
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
        if (player.getDifficulty() == null) {
            player.launchGameChangersScreen();
            player.setfParent(false);
        }

        if (player != null) {
            if(player.getDifficulty() == null || player.getTradeOff() == null) {
                player.setfParent(false);
                this.player.launchGameChangersScreen();
            } else {
                
                this.player.launchMainScreen();}
        }
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
