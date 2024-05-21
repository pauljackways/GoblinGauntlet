package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import seng201.team131.Buyable;
import seng201.team131.Player;
import seng201.team131.Tower;
import seng201.team131.Sellable;

import java.util.ArrayList;
import java.util.List;

public class ShopScreenController extends Controller {

    @FXML
    private ListView<String> LstBuy;

    @FXML
    private ListView<String> LstSell;

    @FXML
    private Button BtnBuySell;
    private Player player;
    private boolean LstSelected = false;
    private List<Sellable> sellableList = new ArrayList<>();
    private List<Buyable> buyableList = new ArrayList<>();;


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
                LstSelected = true;
                if (newValue != null) {
                    int selectedIndex = LstBuy.getSelectionModel().getSelectedIndex();
                    if (selectedIndex != -1) {
                        if (selectedIndex < buyableList.size()) {
                            Buyable selectedTower = buyableList.get(selectedIndex);
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
                LstSelected = false;
                if (newValue != null) {
                    int selectedIndex = LstSell.getSelectionModel().getSelectedIndex();
                    if (selectedIndex != -1) {
                        if (selectedIndex < sellableList.size()) {
                            Sellable selectedTower = sellableList.get(selectedIndex);
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
        if (LstSelected) {
            player.buy((Buyable) player.getSelected());
        } else {
            player.sell((Sellable) player.getSelected());
        }
        player.launchShopScreen();
    }

    private void updateBuyList() {
        LstBuy.getItems().clear();
        buyableList.addAll(player.getDefaultTowers());
        buyableList.addAll(player.getDefaultItems());
        for (Buyable item : buyableList) {
            LstBuy.getItems().add("Level " + item.getLevel() + " " + item.getName());
        }

        LstBuy.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(item);
                int index = getIndex();
                if (index >= 0 && index < buyableList.size() && buyableList.get(index) instanceof Tower) {
                    setDisable(sellableList.size() >= 10);
                } else {
                    setDisable(false);
                }
            }
        });

        LstBuy.refresh();
    }

    private void updateSellList() {
        LstSell.getItems().clear();
        sellableList.addAll(player.getReserveTowerList());
        sellableList.addAll(player.getMainTowerList());
        for (Sellable item : sellableList) {
            LstSell.getItems().add("Level " + item.getLevel() + " " + item.getName());
        }
    }
}