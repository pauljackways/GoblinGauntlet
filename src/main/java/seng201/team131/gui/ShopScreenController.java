package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import seng201.team131.Player;
import seng201.team131.Selectable;
import seng201.team131.Tower;

import java.util.ArrayList;
import java.util.List;

public class ShopScreenController extends Controller {

    @FXML
    private Label labelVillageMarket;

    @FXML
    private ListView<String> LstBuy;

    @FXML
    private ListView<String> LstSell;

    @FXML
    private Button BtnBuySell;

    private Player player;

    public ShopScreenController() {
        //FX load
    }

    public ShopScreenController(Player player) {
        this.player = player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }

    @FXML
    public void initialize() {
        if (player != null) {
            player.launchInfoPane();
            updateBuyList();
            updateSellList();

            LstBuy.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) { // ListView lost focus
                    LstBuy.getSelectionModel().clearSelection();
                }
            });

            LstBuy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    int selectedIndex = LstBuy.getSelectionModel().getSelectedIndex();
                    if (selectedIndex != -1) {
                        if (selectedIndex < player.getDefaultTowers().size()) {
                            Tower selectedTower = player.getDefaultTowers().get(selectedIndex);
                            player.setSelected(selectedTower);
                        } else {
                            player.setSelected(null);
                        }
                    }
                    BtnBuySell.setDisable(false);
                    BtnBuySell.setStyle("-fx-background-color: green;");
                    BtnBuySell.setText("Buy");
                }
            });

            LstSell.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    LstSell.getSelectionModel().clearSelection();
                }
            });

            LstSell.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    int selectedIndex = LstSell.getSelectionModel().getSelectedIndex();
                    if (selectedIndex != -1) {
                        if (selectedIndex < player.getDefaultTowers().size()) {
                            Tower selectedTower = player.getDefaultTowers().get(selectedIndex);
                            player.setSelected(selectedTower);
                        } else {
                            player.setSelected(null);
                        }
                    }
                    BtnBuySell.setDisable(false);
                    BtnBuySell.setStyle("-fx-background-color: red;");
                    BtnBuySell.setText("Sell");
                }
            });
        } else {
            BtnBuySell.setDisable(true);
        }
    }

    @FXML
    private void onBtnBuySell() {
        List<Tower> mainTowerList = player.getmainTowerList();
        List<Tower> reserveTowerList = player.getReserveTowerList();
        List<Tower> combineTowerList = new ArrayList<>();
        combineTowerList.addAll(mainTowerList);
        combineTowerList.addAll(reserveTowerList);
        int selectedIndex = LstBuy.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            if (selectedIndex < player.getDefaultTowers().size()) {
                player.buy(player.getDefaultTowers().get(selectedIndex));
            } else {
                int adjustedIndex = selectedIndex - player.getDefaultTowers().size();
                player.sell(combineTowerList.get(adjustedIndex));
            }
        }
    }

    private void updateBuyList() {
        LstBuy.getItems().clear();
        List<Tower> defaultTowers = player.getDefaultTowers();
        for (Tower tower : defaultTowers) {
            LstBuy.getItems().add("Level " + tower.getLevel() + " " + tower.getName());
        }
    }

    private void updateSellList() {
        List<Tower> mainTowerList = player.getmainTowerList();
        List<Tower> reserveTowerList = player.getReserveTowerList();
        List<Tower> combineTowerList = new ArrayList<>();
        combineTowerList.addAll(mainTowerList);
        combineTowerList.addAll(reserveTowerList);


        LstSell.getItems().clear();
        List<Tower> towerList = combineTowerList;
        for (Tower tower : towerList) {
            LstSell.getItems().add("Level " + tower.getLevel() + " " + tower.getName());
        }
    }
}