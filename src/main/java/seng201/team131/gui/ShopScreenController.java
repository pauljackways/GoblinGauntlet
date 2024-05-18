package seng201.team131.gui;

import javafx.fxml.FXML;
import seng201.team131.Player;

public class ShopScreenController extends Controller{
    private Player player;
    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    @FXML
    public void initialize() {
        if (player != null) {

        }
    }
}
