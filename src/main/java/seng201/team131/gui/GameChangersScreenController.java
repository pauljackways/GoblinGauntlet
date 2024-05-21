package seng201.team131.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static seng201.team131.EnumGamechangers.*;

import java.util.Random;

import seng201.team131.Player;
import seng201.team131.Round;


public class GameChangersScreenController extends Controller {
    private Player player;
    private Integer powerUpSelected = null;
    private Integer favourResource;

    @FXML
    private ImageView ImgEasy;
    @FXML
    private ImageView ImgMed;
    @FXML
    private ImageView ImgHard;
    @FXML
    private ImageView ImgFast;
    @FXML
    private ImageView ImgSabo;
    @FXML
    private ImageView ImgTheft;
    @FXML
    private ImageView ImgSlow;
    @FXML
    private ImageView ImgMoney;
    @FXML
    private ImageView ImgDist;
    @FXML
    private Button BtnBuyPwrUp;


    public GameChangersScreenController() {
        //go FX yourself
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }

    @FXML
    public void onImgEasy() {
        ImgEasy.setOpacity(1);
        ImgMed.setOpacity(0.5);
        ImgHard.setOpacity(0.5);
        player.setDifficulty(EASY);
    }

    @FXML
    public void onImgMed() {
        ImgEasy.setOpacity(0.5);
        ImgMed.setOpacity(1);
        ImgHard.setOpacity(0.5);
        player.setDifficulty(MEDIUM);
    }

    @FXML
    public void onImgHard() {
        ImgEasy.setOpacity(0.5);
        ImgMed.setOpacity(0.5);
        ImgHard.setOpacity(1);
        player.setDifficulty(HARD);
    }

    @FXML
    public void onImgFast() {
        ImgFast.setOpacity(1);
        ImgSabo.setOpacity(0.5);
        ImgTheft.setOpacity(0.5);
        player.setTradeOffs(FAST);
    }

    @FXML
    public void onImgSabo() {
        ImgFast.setOpacity(0.5);
        ImgSabo.setOpacity(1);
        ImgTheft.setOpacity(0.5);
        player.setTradeOffs(SABOTAGE);
    }

    @FXML
    public void onImgTheft() {
        ImgFast.setOpacity(0.5);
        ImgSabo.setOpacity(0.5);
        ImgTheft.setOpacity(1);
        player.setTradeOffs(THEFT);
    }

    @FXML
    public void onImgSlow() {
        ImgSlow.setOpacity(0.5);
        ImgMoney.setOpacity(1);
        ImgDist.setOpacity(1);
        powerUpSelected = 0;
        player.setPowerUp(SLOW);
    }

    @FXML
    public void onImgMoney() {
        ImgSlow.setOpacity(1);
        ImgMoney.setOpacity(0.5);
        ImgDist.setOpacity(1);
        powerUpSelected = 1;
        player.setPowerUp(MONEY);
    }

    @FXML
    public void onImgDist() {
        ImgSlow.setOpacity(1);
        ImgMoney.setOpacity(1);
        ImgDist.setOpacity(0.5);
        powerUpSelected = 2;
        player.setPowerUp(DISTRIBUTION);
    }
    @FXML
    public void onBtnBuyPwrUp() {
        if(powerUpSelected == null){
            
        }
        else if(powerUpSelected == 0){
            ImgSlow.setOpacity(0.5);
            ImgSlow.setDisable(true);
            ImgMoney.setDisable(true);
            ImgDist.setDisable(true);
            
            
        }
        else if(powerUpSelected == 1){
            ImgMoney.setOpacity(0.5);
            ImgSlow.setDisable(true);
            ImgMoney.setDisable(true);
            ImgDist.setDisable(true);
            
        }
        else if(powerUpSelected == 2){
            ImgDist.setOpacity(0.5);
            ImgSlow.setDisable(true);
            ImgMoney.setDisable(true);
            ImgDist.setDisable(true);

            Random random = new Random();
            int randomResource = random.nextInt(3);
            player.setFavorResource(randomResource);
        }
        
    }
    public void initialize(){
        if (player != null) {
            Random random = new Random();
            int favourResource = random.nextInt(3);

            ImgEasy.setOpacity(0.5);
            ImgMed.setOpacity(0.5);
            ImgHard.setOpacity(0.5);
            ImgFast.setOpacity(0.5);
            ImgSabo.setOpacity(0.5);
            ImgTheft.setOpacity(0.5);
            ImgSlow.setOpacity(1);
            ImgMoney.setOpacity(1);
            ImgDist.setOpacity(1);
            try {
                switch (player.getDifficulty()) {
                    case EASY:
                        ImgEasy.setOpacity(1);
                        break;
                    case MEDIUM:
                        ImgMed.setOpacity(1);
                        break;
                    case HARD:
                        ImgHard.setOpacity(1);
                        break;
                    default:
                        break;
                }
            } catch (NullPointerException e) {
            }

            try {
                switch (player.getTradeOff()) {
                    case FAST:
                        ImgFast.setOpacity(1);
                        break;
                    case SABOTAGE:
                        ImgSabo.setOpacity(1);
                        break;
                    case THEFT:
                        ImgTheft.setOpacity(1);
                        break;
                    default:
                        break;
                }
            } catch (NullPointerException e) {
            }

            try {
                switch (player.getPowerUp()) {
                    case SLOW:
                        ImgSlow.setOpacity(0.5);
                        break;
                    case MONEY:
                        ImgMoney.setOpacity(0.5);
                        break;
                    case DISTRIBUTION:
                        ImgDist.setOpacity(0.5);
                        break;
                    default:
                        break;
                }
                ImgSlow.setDisable(true);
                ImgMoney.setDisable(true);
                ImgDist.setDisable(true);
            } catch (NullPointerException e) {
            }
        }
        
        
    }   
}


