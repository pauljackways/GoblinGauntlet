package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    @FXML
    public void initialize() {
        //Just testing if name, pfp and rounds get set properly
        /*if (player == null) {
            needsInitialization = true;
            System.out.println("Player is null, initialization postponed.");
            return;
        }

        System.out.println(player.getName());
        System.out.println(player.getPfp());
        System.out.println(player.getRounds());
        
        
        System.out.println("Initialization complete.");
        needsInitialization = false; */
    }
}
