package seng201.team131.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import seng201.team131.EnumItems;
import seng201.team131.Item;
import seng201.team131.Player;
import seng201.team131.Tower;
import seng201.team131.EnumItems;

import static seng201.team131.EnumItems.*;
/**
 * Screen for the user to swap towers between the main list and the reserve list. Also informs the player of damaged towers and allows the user to repair/upgrade towers if they have the relevant items
 */
public class TowerScreenController extends Controller {
    private Player player;
    private boolean needsInitialization = false;
    private int mainTowerPointer;
    private int reserveTowerPointer;

    @FXML
    private ImageView mainTower1;
    @FXML
    private ImageView mainTower2;
    @FXML
    private ImageView mainTower3;
    @FXML
    private ImageView mainTower4;
    @FXML
    private ImageView mainTower5;
    @FXML
    private ImageView reserveTower1;
    @FXML
    private ImageView reserveTower2;
    @FXML
    private ImageView reserveTower3;
    @FXML
    private ImageView reserveTower4;
    @FXML
    private ImageView reserveTower5;
    @FXML
    private Button BtnTowerSwap;
    @FXML
    private Button BtnUpgradeTower;
    @FXML
    private Button BtnRepairTower;
    private List<ImageView> imageViewList = new ArrayList<>();
    private List<ImageView> imageViewListReserve = new ArrayList<>();


    public void SetupScreenController(Player player) {
        this.player = player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }

    /**
     * Displays one of the 5 towers in the main tower list
     */
    public void onMainClick1() {
        mainTower1.setOpacity(0.5);
        mainTower2.setOpacity(1);
        mainTower3.setOpacity(1);
        mainTower4.setOpacity(1);
        mainTower5.setOpacity(1);
        mainTowerPointer = 0;
        try {
            player.setSelected(player.getMainTowerList().get(0));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }

    }

    public void onMainClick2() {
        mainTower1.setOpacity(1);
        mainTower2.setOpacity(0.5);
        mainTower3.setOpacity(1);
        mainTower4.setOpacity(1);
        mainTower5.setOpacity(1);
        mainTowerPointer = 1;
        try {
            player.setSelected(player.getMainTowerList().get(1));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onMainClick3() {
        mainTower1.setOpacity(1);
        mainTower2.setOpacity(1);
        mainTower3.setOpacity(0.5);
        mainTower4.setOpacity(1);
        mainTower5.setOpacity(1);
        mainTowerPointer = 2;
        try {
            player.setSelected(player.getMainTowerList().get(2));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onMainClick4() {
        mainTower1.setOpacity(1);
        mainTower2.setOpacity(1);
        mainTower3.setOpacity(1);
        mainTower4.setOpacity(0.5);
        mainTower5.setOpacity(1);
        mainTowerPointer = 3;
        try {
            player.setSelected(player.getMainTowerList().get(3));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onMainClick5() {
        mainTower1.setOpacity(1);
        mainTower2.setOpacity(1);
        mainTower3.setOpacity(1);
        mainTower4.setOpacity(1);
        mainTower5.setOpacity(0.5);
        mainTowerPointer = 4;
        try {
            player.setSelected(player.getMainTowerList().get(4));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    /**
     * Displays one of the 5 towers in the reserve list
     */
    public void onReserveClick1() {
        reserveTower1.setOpacity(0.5);
        reserveTower2.setOpacity(1);
        reserveTower3.setOpacity(1);
        reserveTower4.setOpacity(1);
        reserveTower5.setOpacity(1);
        reserveTowerPointer = 0;
        try {
            player.setSelected(player.getReserveTowerList().get(0));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onReserveClick2() {
        reserveTower1.setOpacity(1);
        reserveTower2.setOpacity(0.5);
        reserveTower3.setOpacity(1);
        reserveTower4.setOpacity(1);
        reserveTower5.setOpacity(1);
        reserveTowerPointer = 1;
        try {
            player.setSelected(player.getReserveTowerList().get(1));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onReserveClick3() {
        reserveTower1.setOpacity(1);
        reserveTower2.setOpacity(1);
        reserveTower3.setOpacity(0.5);
        reserveTower4.setOpacity(1);
        reserveTower5.setOpacity(1);
        reserveTowerPointer = 2;
        try {
            player.setSelected(player.getReserveTowerList().get(2));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onReserveClick4() {
        reserveTower1.setOpacity(1);
        reserveTower2.setOpacity(1);
        reserveTower3.setOpacity(1);
        reserveTower4.setOpacity(0.5);
        reserveTower5.setOpacity(1);
        reserveTowerPointer = 3;
        try {
            player.setSelected(player.getReserveTowerList().get(3));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }

    public void onReserveClick5() {
        reserveTower1.setOpacity(1);
        reserveTower2.setOpacity(1);
        reserveTower3.setOpacity(1);
        reserveTower4.setOpacity(1);
        reserveTower5.setOpacity(0.5);
        reserveTowerPointer = 4;
        try {
            player.setSelected(player.getReserveTowerList().get(4));
        } catch (IndexOutOfBoundsException e) {
            player.setSelected(null);
        }
    }
    /**
     * Swaps the selected main tower with the selected reserve tower. The towers get swapped between the list, and that subsequently swaps them in the gui.
     */
    public void OnBtnTowerSwap(){
        List<Tower> mainTowerList = player.getMainTowerList();
        List<Tower> reserveTowerList = player.getReserveTowerList();


        if (reserveTowerPointer >= reserveTowerList.size() && mainTowerPointer >= mainTowerList.size()){}
        else{
            if (reserveTowerPointer >= reserveTowerList.size()) {
            Tower temp = mainTowerList.get(mainTowerPointer);
            reserveTowerList.add(temp);
            mainTowerList.remove(mainTowerPointer);
            }

            else if (mainTowerPointer >= mainTowerList.size()) {
                Tower tempTower = reserveTowerList.get(reserveTowerPointer);
                mainTowerList.add(tempTower);
                reserveTowerList.remove(reserveTowerPointer);

            }


            else{
                Tower tempTower = mainTowerList.get(mainTowerPointer);
                mainTowerList.set(mainTowerPointer, reserveTowerList.get(reserveTowerPointer));
                reserveTowerList.set(reserveTowerPointer, tempTower);
            }
        }

        mainTowerPointer = -1;
        reserveTowerPointer = -1;
        player.launchTowerScreen();
    }

    /**
     * loops through the items the player has and checks if they have the item they are trying to use, if they do, the item is removed and applied to the selected tower.
     */
    public void onBtnUpgradeTower() {
        if (player.getSelected() != null) {
            for (int i = 0; i < player.getItemList().size(); i++) {
                if (player.getItemList().get(i).getType() == UPGRADE) {
                    player.getItemList().remove(i);
                    Tower selectedTower = (Tower) player.getSelected();
                    selectedTower.levelUp();
                    break;
                }
            }
        }
    }

    /**
     * loops through the items the player has and checks if they have the item they are trying to use, if they do, the item is removed and applied to the selected tower.
     */
    public void onBtnRepairTower(){
        if(player.getSelected() != null){
            for (int i = 0; i < player.getItemList().size(); i++) {
                if(player.getItemList().get(i).getType() == REPAIR) {
                    player.getItemList().remove(i);
                    Tower selectedTower = (Tower) player.getSelected();
                    selectedTower.repairTwr();
                    System.out.println(player.getItemList());
                    break;
                }
            }
        }
        player.launchTowerScreen();

    }

    /**
     * Sets all the default opacitys.
     */
    @FXML
    public void initialize() {
        if (player != null) {
            BtnRepairTower.setDisable(true);
            BtnUpgradeTower.setDisable(true);

            for (int i = 0; i < player.getItemList().size(); i++) {
                if(player.getItemList().get(i).getType() == REPAIR) {
                    BtnRepairTower.setDisable(false);
                    break;
                }
                if(player.getItemList().get(i).getType() == UPGRADE) {
                    BtnUpgradeTower.setDisable(false);
                    break;
                }
            }
            
            player.launchInfoPane();

            mainTower1.setOpacity(1);
            mainTower2.setOpacity(1);
            mainTower3.setOpacity(1);
            mainTower4.setOpacity(1);
            mainTower5.setOpacity(1);

            reserveTower1.setOpacity(1);
            reserveTower2.setOpacity(1);
            reserveTower3.setOpacity(1);
            reserveTower4.setOpacity(1);
            reserveTower5.setOpacity(1);

            mainTower1.setOnMouseClicked(event -> onMainClick1());
            mainTower2.setOnMouseClicked(event -> onMainClick2());
            mainTower3.setOnMouseClicked(event -> onMainClick3());
            mainTower4.setOnMouseClicked(event -> onMainClick4());
            mainTower5.setOnMouseClicked(event -> onMainClick5());

            reserveTower1.setOnMouseClicked(event -> onReserveClick1());
            reserveTower2.setOnMouseClicked(event -> onReserveClick2());
            reserveTower3.setOnMouseClicked(event -> onReserveClick3());
            reserveTower4.setOnMouseClicked(event -> onReserveClick4());
            reserveTower5.setOnMouseClicked(event -> onReserveClick5());




            List<Tower> mainTowerList = player.getMainTowerList();
            List<ImageView> imageViewList = new ArrayList<>();
            imageViewList.add(mainTower1);
            imageViewList.add(mainTower2);
            imageViewList.add(mainTower3);
            imageViewList.add(mainTower4);
            imageViewList.add(mainTower5);

            for (int i = 0; i < mainTowerList.size(); i++) {
                Image newImage = new Image(mainTowerList.get(i).getImage());
                imageViewList.get(i).setImage(newImage);
                System.out.println(mainTowerList.get(i).getHealth());
                if (mainTowerList.get(i).getHealth() < 1.0) {
                    DropShadow redGlow = new DropShadow(5, Color.RED);
                    redGlow.setSpread(0.1);
                    imageViewList.get(i).setEffect(redGlow);
                }
            }

            List<Tower> reserveTowerList = player.getReserveTowerList();
            imageViewListReserve.add(reserveTower1);
            imageViewListReserve.add(reserveTower2);
            imageViewListReserve.add(reserveTower3);
            imageViewListReserve.add(reserveTower4);
            imageViewListReserve.add(reserveTower5);



            for (int i = 0; i < reserveTowerList.size(); i++) {
                Image newImage = new Image(reserveTowerList.get(i).getImage());
                imageViewListReserve.get(i).setImage(newImage);
                if (reserveTowerList.get(i).getHealth() < 1.0) {
                    DropShadow redGlow = new DropShadow(5, Color.RED);
                    redGlow.setSpread(0.1);
                    imageViewListReserve.get(i).setEffect(redGlow);
                }
            }
        }
    }
}
