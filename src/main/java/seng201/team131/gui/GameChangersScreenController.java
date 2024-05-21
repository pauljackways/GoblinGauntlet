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
        powerUpSelected = 0;
        player.setPwrUps(SLOW);
    }

    @FXML
    public void onImgMoney() {
        ImgMoney.setOpacity(0.5);
        powerUpSelected = 1;
        player.setPwrUps(MONEY);
    }

    @FXML
    public void onImgDist() {
        ImgDist.setOpacity(0.5);
        powerUpSelected = 2;
        player.setPwrUps(DISTRIBUTION);
    }
    @FXML
    public void onBtnBuyPwrUp() {
        if(powerUpSelected == 0){
            ImgSlow.setOpacity(0.5);
            ImgSlow.setDisable(true);
            
            
        }
        else if(powerUpSelected == 0){
            ImgMoney.setOpacity(0.5);
            ImgMoney.setDisable(true);
            
        }
        else if(powerUpSelected == 0){
            ImgDist.setOpacity(0.5);
            ImgDist.setDisable(true);
        }
        else{
            //Do Nothing
        }
    }
    




    

        
    

    public void initialize(){
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

        if (player != null) {
            if(player.getDifficulty() != null){
                int indexDiff = player.getDifficulty().ordinal();
                if(indexDiff == 0){ImgEasy.setOpacity(1);}
                if(indexDiff == 1){ImgMed.setOpacity(1);}
                if(indexDiff == 2){ImgHard.setOpacity(1);}
            }
            if(player.getTradeOffs() != null){
                int indexChanger = player.getTradeOffs().ordinal();
                if(indexChanger == 3){ImgFast.setOpacity(1);}
                if(indexChanger == 4){ImgSabo.setOpacity(1);}
                if(indexChanger == 5){ImgTheft.setOpacity(1);}
            }
            if(player.getPwrUps() != null){
                int indexPwrup = player.getPwrUps().ordinal();
                if(indexPwrup == 6){ImgSlow.setOpacity(0.5);}
                if(indexPwrup == 7){ImgMoney.setOpacity(0.5);}
                if(indexPwrup == 8){ImgDist.setOpacity(0.5);}
            }
        }
        
        
    }   
}


