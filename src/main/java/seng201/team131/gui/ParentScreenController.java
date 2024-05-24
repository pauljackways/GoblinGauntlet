package seng201.team131.gui;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team131.Player;
/**
 * Intermediate screen that acts as the player menu
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

    /**
     * Button to reach the tower management screen
     */
    @FXML
    public void onBtnTowerScreen() {
        if (player != null) {
            player.setfParent(false);
            this.player.launchTowerScreen();
        }
    }
    /**
     * Button to begin the game, reverts player to the game changers (Citadel of Sorcerers) screen if required options are not selected
     */
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
    /**
     * Button to reach the game changers screen (difficulty, tradeoffs, powerups)
     */
    @FXML
    public void onBtnGameChangersScreen() {
        if (player != null) {
            player.setfParent(false);
            this.player.launchGameChangersScreen();
        }
    }
    /**
     * Button to reach the shop screen
     */
    @FXML
    public void onBtnShopScreen() {
        if (player != null) {
            player.setfParent(false);
            this.player.launchShopScreen();
        }
    }
    /**
     * Handles the transitions in and out of the parent screen. namely, the back button, which is not displayed when in this screen
     */
    @FXML
    public void initialize() {
        if (player != null) {
            player.setfParent(true);
            player.setSelected(null);
            player.launchUserPane();
        }
    }
}
