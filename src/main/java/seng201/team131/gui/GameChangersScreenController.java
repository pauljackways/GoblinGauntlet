package seng201.team131.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static seng201.team131.EnumGamechangers.*;

import java.util.Random;

import seng201.team131.EnumGamechangers;
import seng201.team131.Gamechangers;
import seng201.team131.Player;
import seng201.team131.Round;
import seng201.team131.Selectable;

/**
 * The logic behind the Game Changers Screen, setting all the image views to the correct opacity based on the one clicked
 */
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
        player.setSelected((Selectable) new Gamechangers(EASY, player.getFavourResource()));
    }

    @FXML
    public void onImgMed() {
        ImgEasy.setOpacity(0.5);
        ImgMed.setOpacity(1);
        ImgHard.setOpacity(0.5);
        player.setDifficulty(MEDIUM);
        player.setSelected((Selectable) new Gamechangers(MEDIUM, player.getFavourResource()));
    }

    @FXML
    public void onImgHard() {
        ImgEasy.setOpacity(0.5);
        ImgMed.setOpacity(0.5);
        ImgHard.setOpacity(1);
        player.setDifficulty(HARD);
        player.setSelected((Selectable) new Gamechangers(HARD, player.getFavourResource()));
    }

    @FXML
    public void onImgFast() {
        ImgFast.setOpacity(1);
        ImgSabo.setOpacity(0.5);
        ImgTheft.setOpacity(0.5);
        player.setTradeOffs(FAST);
        player.setSelected((Selectable) new Gamechangers(FAST, player.getFavourResource()));
    }

    @FXML
    public void onImgSabo() {
        ImgFast.setOpacity(0.5);
        ImgSabo.setOpacity(1);
        ImgTheft.setOpacity(0.5);
        player.setTradeOffs(SABOTAGE);
        player.setSelected((Selectable) new Gamechangers(SABOTAGE, player.getFavourResource()));
    }

    @FXML
    public void onImgTheft() {
        ImgFast.setOpacity(0.5);
        ImgSabo.setOpacity(0.5);
        ImgTheft.setOpacity(1);
        player.setTradeOffs(THEFT);
        player.setSelected((Selectable) new Gamechangers(THEFT, player.getFavourResource()));
    }

    @FXML
    public void onImgSlow() {
        ImgSlow.setOpacity(0.5);
        ImgMoney.setOpacity(1);
        ImgDist.setOpacity(1);
        powerUpSelected = 0;
        player.setPowerUp(SLOW);
        player.setSelected((Selectable) new Gamechangers(SLOW, player.getFavourResource()));
    }

    @FXML
    public void onImgMoney() {
        ImgSlow.setOpacity(1);
        ImgMoney.setOpacity(0.5);
        ImgDist.setOpacity(1);
        powerUpSelected = 1;
        player.setPowerUp(MONEY);
        player.setSelected((Selectable) new Gamechangers(MONEY, player.getFavourResource()));
    }

    @FXML
    public void onImgDist() {
        ImgSlow.setOpacity(1);
        ImgMoney.setOpacity(1);
        ImgDist.setOpacity(0.5);
        powerUpSelected = 2;
        player.setPowerUp(DISTRIBUTION);
        player.setSelected((Selectable) new Gamechangers(DISTRIBUTION, player.getFavourResource()));
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
            player.launchInfoPane();


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


