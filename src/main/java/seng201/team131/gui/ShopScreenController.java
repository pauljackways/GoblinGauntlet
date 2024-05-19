package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import seng201.team131.Player;
import seng201.team131.Tower;

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
            updateBuyList();
            updateSellList();

            // Add listener to clear selection when ListView loses focus
            LstBuy.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) { // ListView lost focus
                    LstBuy.getSelectionModel().clearSelection();
                }
            });

            LstBuy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    BtnBuySell.setDisable(false);
                    BtnBuySell.setStyle("-fx-background-color: green;");
                    BtnBuySell.setText("Buy");
                }
            });

            LstSell.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) { // ListView lost focus
                    LstSell.getSelectionModel().clearSelection();
                }
            });

            LstSell.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
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
        String selectedTower = LstBuy.getSelectionModel().getSelectedItem();
        if (selectedTower != null) {
            String[] parts = selectedTower.split(" ");
            int level = Integer.parseInt(parts[1]);
            String name = parts[2];
            for (Tower tower : player.getDefaultTowers()) {
                if (tower.getName().equals(name) && tower.getLevel() == level) {
                    player.buy(tower);
                    break;
                }
            }
        } else {
            selectedTower = LstSell.getSelectionModel().getSelectedItem();
            if (selectedTower != null) {
                String[] parts = selectedTower.split(" ");
                int level = Integer.parseInt(parts[1]);
                String name = parts[2];
                for (Tower tower : player.getTowerList()) {
                    if (tower.getName().equals(name) && tower.getLevel() == level) {
                        player.sell(tower);
                        break;
                    }
                }
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
        LstSell.getItems().clear();
        List<Tower> towerList = player.getTowerList();
        for (Tower tower : towerList) {
            LstSell.getItems().add("Level " + tower.getLevel() + " " + tower.getName());
        }
    }
}