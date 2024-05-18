package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import seng201.team131.Player;

public class SetupScreenController extends Controller{
    private Player player;

    @FXML 
    private ImageView Pfp1;
    @FXML 
    private ImageView Pfp2;
    @FXML 
    private ImageView Pfp3;
    @FXML 
    private ImageView Pfp4;
    @FXML 
    private ImageView Pfp5;
    @FXML 
    private Slider SldrRounds;
    @FXML
    private Button BtnPlayStartScreen;
    @FXML
    private TextField TxtFldName;


    public SetupScreenController(Player player) {
        this.player = player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public SetupScreenController() {
        // Default constructor for FXLoader's sick and twisted desires
    }
    public void onBtnPlayStartScreen() {
        this.player.launchParentScreen();
    }
    public void initialize() {

    }
}

