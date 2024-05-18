package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team131.Player;

public class GameChangersScreenController {
    private Player player;
    public GameChangersScreenController(Player newPlayer) {
        player = newPlayer;
    }
    @FXML
    private Button BtnDiffEasy;
    @FXML
    private Button BtnDiffMed;
    @FXML
    private Button BtnDiffHard;
    @FXML
    private Button BtnTradeOff1;
    @FXML
    private Button BtnTradeOff2;
    @FXML
    private Button BtnTradeOff3;
    @FXML
    private Button BtnPwrUp1;
    @FXML
    private Button BtnPwrUp2;
    @FXML
    private Button BtnPwrUp3;
    public void setPlayer(Player player) {
        this.player = player;
    }
    public GameChangersScreenController() {
        //go FX yourself
    }
    
    public void initialize() {

    }

}
