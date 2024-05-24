package seng201.team131.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static seng201.team131.EnumGamechangers.*;

import java.util.Random;

import seng201.team131.EnumGamechangers;
import seng201.team131.Gamechangers;
import seng201.team131.Player;
import seng201.team131.Selectable;

/**
 * The logic behind the Game Changers Screen, setting all the image views to the correct opacity based on the one clicked. Sets round parameters in the player class for use in the next round instance
 */
public class GameChangersScreenController extends Controller {
    private Player player;
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
    /**
     * On player choosing easy difficulty
     */
    @FXML
    public void onImgEasy() {
        ImgEasy.setOpacity(1);
        ImgMed.setOpacity(0.5);
        ImgHard.setOpacity(0.5);
        player.setDifficulty(EASY);
        player.setSelected((Selectable) new Gamechangers(EASY, player.getFavourResource()));
    }
    /**
     * On player choosing medium difficulty
     */
    @FXML
    public void onImgMed() {
        ImgEasy.setOpacity(0.5);
        ImgMed.setOpacity(1);
        ImgHard.setOpacity(0.5);
        player.setDifficulty(MEDIUM);
        player.setSelected((Selectable) new Gamechangers(MEDIUM, player.getFavourResource()));
    }

    /**
     * On player choosing hard difficulty
     */
    @FXML
    public void onImgHard() {
        ImgEasy.setOpacity(0.5);
        ImgMed.setOpacity(0.5);
        ImgHard.setOpacity(1);
        player.setDifficulty(HARD);
        player.setSelected((Selectable) new Gamechangers(HARD, player.getFavourResource()));
    }

    /**
     * On player choosing speed tradeoff
     */
    @FXML
    public void onImgFast() {
        ImgFast.setOpacity(1);
        ImgSabo.setOpacity(0.5);
        ImgTheft.setOpacity(0.5);
        player.setTradeOffs(FAST);
        player.setSelected((Selectable) new Gamechangers(FAST, player.getFavourResource()));
    }
    /**
     * On player choosing sabotage tradeoff
     */
    @FXML
    public void onImgSabo() {
        ImgFast.setOpacity(0.5);
        ImgSabo.setOpacity(1);
        ImgTheft.setOpacity(0.5);
        player.setTradeOffs(SABOTAGE);
        player.setSelected((Selectable) new Gamechangers(SABOTAGE, player.getFavourResource()));
    }

    /**
     * On player choosing theft tradeoff
     */
    @FXML
    public void onImgTheft() {
        ImgFast.setOpacity(0.5);
        ImgSabo.setOpacity(0.5);
        ImgTheft.setOpacity(1);
        player.setTradeOffs(THEFT);
        player.setSelected((Selectable) new Gamechangers(THEFT, player.getFavourResource()));
    }

    /**
     * On player choosing slow powerup
     */
    @FXML
    public void onImgSlow() {
        ImgSlow.setOpacity(1);
        ImgMoney.setOpacity(0.5);
        ImgDist.setOpacity(0.5);
        player.setPowerUp(SLOW);
        player.setSelected((Selectable) new Gamechangers(SLOW, player.getFavourResource()));
    }

    /**
     * On player choosing money powerup
     */
    @FXML
    public void onImgMoney() {
        ImgSlow.setOpacity(0.5);
        ImgMoney.setOpacity(1);
        ImgDist.setOpacity(0.5);
        player.setPowerUp(MONEY);
        player.setSelected((Selectable) new Gamechangers(MONEY, player.getFavourResource()));
    }
    /**
     * On player choosing resource distribution powerup
     */
    @FXML
    public void onImgDist() {
        ImgSlow.setOpacity(0.5);
        ImgMoney.setOpacity(0.5);
        ImgDist.setOpacity(1);
        player.setPowerUp(DISTRIBUTION);
        player.setSelected((Selectable) new Gamechangers(DISTRIBUTION, player.getFavourResource()));
    }
    /**
     * On player purchasing powerup
     */
    @FXML
    public void onBtnBuyPwrUp() {
        switch(player.getPowerUp()) {
            case SLOW -> {
                ImgSlow.setOpacity(1);
                break;
            }
            case MONEY -> {
                ImgMoney.setOpacity(1);
                break;
            }
            case DISTRIBUTION -> {
                ImgDist.setOpacity(1);
                break;
            }
            default -> {
                break;
            }
        }
        if ((player.getPowerUp() != null) && !player.getFPowerUpBought()) {
            player.setFPowerUpBought(true);
            player.setMoney(player.getMoney() - 250f);
            ImgSlow.setDisable(true);
            ImgMoney.setDisable(true);
            ImgDist.setDisable(true);
            BtnBuyPwrUp.setDisable(true);
            ImgSlow.setOpacity(0.5);
            ImgMoney.setOpacity(0.5);
            ImgDist.setOpacity(0.5);
        }
        if (player.getFPowerUpBought()) {
            BtnBuyPwrUp.setDisable(true);
            ImgSlow.setDisable(true);
            ImgMoney.setDisable(true);
            ImgDist.setDisable(true);
        }
    }









    /**
     * On player choosing slow powerupSets all buttons to their current state according to player. Will always be the same as the previous round upon starting a new round.
     */
    public void initialize(){
        if (player != null) {
            player.launchInfoPane();
            if (player.getFPowerUpBought()) {
                onBtnBuyPwrUp();
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

            } catch (NullPointerException e) {
            }
            ImgEasy.setOpacity(0.5);
            ImgMed.setOpacity(0.5);
            ImgHard.setOpacity(0.5);
            ImgFast.setOpacity(0.5);
            ImgSabo.setOpacity(0.5);
            ImgTheft.setOpacity(0.5);
            ImgSlow.setOpacity(0.5);
            ImgMoney.setOpacity(0.5);
            ImgDist.setOpacity(0.5);

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
                        ImgSlow.setOpacity(1);
                        break;
                    case MONEY:
                        ImgMoney.setOpacity(1);
                        break;
                    case DISTRIBUTION:
                        ImgDist.setOpacity(1);
                        break;
                    default:
                        break;
                }
            } catch (NullPointerException e) {
            }


        }


    }   
}


