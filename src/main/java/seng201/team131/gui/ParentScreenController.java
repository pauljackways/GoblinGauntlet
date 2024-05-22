package seng201.team131.gui;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team131.Player;

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
        Random random = new Random();
        int randomTower = random.nextInt(player.getMainTowerList().size());

        switch (player.getDifficulty()) {
            case EASY:
                if(player.getRound() != 1){
                    player.getMainTowerList().get(randomTower).dmgTower();
                }
                break;

            case MEDIUM:
                if(player.getRound() != 1){
                    player.getMainTowerList().get(randomTower).dmgTower();
                    player.getMainTowerList().get(randomTower).dmgTower();
                }
                break;

            case HARD:
                player.deleteTower();
                break;

            default:
                break;
        }

        
        if(player.getRound() != 1){
            player.getMainTowerList().get(randomTower).dmgTower();
            //System.out.println(player.getMainTowerList().get(randomTower).getHealth());
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
