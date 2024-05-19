package seng201.team131.gui;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng201.team131.Player;

public class SetupScreenController extends Controller{
    private Player player;
    private String selectedPfp = "Pfp1";
    private String variableToPass = null;
    private String playerName;
    private int numRounds;

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

    private Controller backgroundController;
    public SetupScreenController(Player player, Controller controller) {
        this.player = player;
        this.backgroundController = controller;
    }
    public SetupScreenController() {
        // Default constructor for FXLoader's sick and twisted desires
    }
    public void onBtnPlayStartScreen() {
        playerName = TxtFldName.getText();
        numRounds = (int) SldrRounds.getValue();
        if (playerName.isEmpty()) {
            playerName = "You forgot to type you name idiot!!!";
        }
    
        if (selectedPfp != null) {
            switch (selectedPfp) {
                case "Pfp1":
                    variableToPass = "team-131/scr/main/resources/images/goblin1.jpeg";
                    break;
                case "Pfp2":
                    variableToPass = "team-131/scr/main/resources/images/goblin2.jpeg";
                    break;
                case "Pfp3":
                    variableToPass = "team-131/scr/main/resources/images/goblin3.jpeg";
                    break;
                case "Pfp4":
                    variableToPass = "team-131/scr/main/resources/images/goblin4.jpeg";
                    break;
                case "Pfp5":
                    variableToPass = "team-131/scr/main/resources/images/goblin5.jpeg";
                    break;
            }
        }
    
        player.setRounds(numRounds);
        player.setPfp(variableToPass);
        player.setName(playerName);
        this.player.launchParentScreen();
    }
    

    public void onPfpClick1() { 
        Pfp1.setOpacity(1);
        Pfp2.setOpacity(0.5);
        Pfp3.setOpacity(0.5);
        Pfp4.setOpacity(0.5);
        Pfp5.setOpacity(0.5);
        selectedPfp = "Pfp1";
    }
    public void onPfpClick2() { 
        Pfp1.setOpacity(0.5);
        Pfp2.setOpacity(1);
        Pfp3.setOpacity(0.5);
        Pfp4.setOpacity(0.5);
        Pfp5.setOpacity(0.5);
        selectedPfp = "Pfp2";
    }
    public void onPfpClick3() { 
        Pfp1.setOpacity(0.5);
        Pfp2.setOpacity(0.5);
        Pfp3.setOpacity(1);
        Pfp4.setOpacity(0.5);
        Pfp5.setOpacity(0.5);
        selectedPfp = "Pfp3";
    }
    public void onPfpClick4() { 
        Pfp1.setOpacity(0.5);
        Pfp2.setOpacity(0.5);
        Pfp3.setOpacity(0.5);
        Pfp4.setOpacity(1);
        Pfp5.setOpacity(0.5);
        selectedPfp = "Pfp4";
    }
    public void onPfpClick5() { 
        Pfp1.setOpacity(0.5);
        Pfp2.setOpacity(0.5);
        Pfp3.setOpacity(0.5);
        Pfp4.setOpacity(0.5);
        Pfp5.setOpacity(1);
        selectedPfp = "Pfp5";
    }
    

    public void initialize() {
        Pfp1.setOpacity(0.5);
        Pfp2.setOpacity(0.5);
        Pfp3.setOpacity(0.5);
        Pfp4.setOpacity(0.5);
        Pfp5.setOpacity(0.5);

        Pfp1.setOnMouseClicked(event -> onPfpClick1());
        Pfp2.setOnMouseClicked(event -> onPfpClick2());
        Pfp3.setOnMouseClicked(event -> onPfpClick3());
        Pfp4.setOnMouseClicked(event -> onPfpClick4());
        Pfp5.setOnMouseClicked(event -> onPfpClick5());



        



        
        
    }
}

