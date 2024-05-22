package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import seng201.team131.Player;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import seng201.team131.Round;
import seng201.team131.Tower;

import java.util.Random;

public class EndScreenController extends Controller{
    private Player player;
    private Float moneyMade = 0.0f;
    private Random random = new Random();
    private String excuse;
    private Round round;

    private Integer failCount;
    @FXML

    private Button BtnExcuse;
    @FXML

    private Label LblOutcome;
    @FXML
    private Label LblDmg;
    @FXML

    private Label LblInfo;
    @FXML
    private ImageView ImgEnd;
    public void onBtnExcuse() {
        player.setFavorResource(3);
        player.launchParentScreen();
        player.nextRound();
    }
    public void calculateInfo(){
        for (int i=0; i<round.getResultCartList().size(); i++) {
            moneyMade += round.getResultCartList().get(i).getFillLevel() * round.getMoneyPerFillLevel();
        }
        LblInfo.setText("Carts filled: " + (round.getResultCartList().size()-failCount) + "/" + round.getResultCartList().size() + "\n" +
                        "Money earnt: $" + moneyMade);
        player.setMoney(player.getMoney() + moneyMade);
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    public EndScreenController() {
        // I'm ofFXnded
    }
    public void fail() {
        player.loseLife();
        ImgEnd.setImage(new Image("images/fail.jpeg"));
        LblOutcome.setText("Uh oh... You're in trouble... Quick! come up with an excuse!");
        switch(random.nextInt(6)) {
            case 0:
                excuse = "\"Train got a flat tyre!\"";
                break;
            case 1:
                excuse = "\"It was cloudy! the moon couldn't charge my Ether Crystals!\"";
                break;
            case 2:
                excuse = "\"My appologies, Mrs. Glazgrong.\nI will engage in meditation and self-reflection over this.\"";
                break;
            case 3:
                excuse = "\"The plumber didn't show up.\"";
                break;
            case 4:
                excuse = "\"I didn't miss thaaaaaat many\"";
                break;
            case 5:
                excuse = "\"Soz g\"";
                break;
        }
        BtnExcuse.setText(excuse);
        calculateInfo();
    }
    public void success() {
        ImgEnd.setImage(new Image("images/success.jpeg"));
        LblOutcome.setText("A successful delivery. Safe for another day...");
        BtnExcuse.setText("\"Pleasure doing business\"");
        calculateInfo();
    }
    public void endGame() {
        player.setSelected(null);
        if ()
        ImgEnd.setImage(new Image("images/prison.jpeg"));
        LblOutcome.setText("Uh oh... You're in trouble... Quick! come up with an excuse!");
        calculateInfo();
    }
    @FXML
    public void initialize() {
        if (player != null) {
            player.setSelected(null);
            int randomTower = random.nextInt(player.getMainTowerList().size());
            switch (player.getDifficulty()) {
                case EASY:
                    if(player.getRound() != 1){
                        player.getMainTowerList().get(randomTower).dmgTower();
                    }
                    break;

                case MEDIUM:
                    if(player.getRound() != 1){
                        player.getMainTowerList().get(randomTower).dmgTower();
                        player.getMainTowerList().get(randomTower).dmgTower();
                    }
                    break;

                case HARD:
                    if (random.nextInt(2) == 1) {
                        Tower dummyTower = player.getMainTowerList().get(randomTower);
                        player.setSelected(dummyTower);
                        LblDmg.setText("Catastrophic disaster.\nMultiple orcslave fatalities.\nYour tower has imploded\nand is no longer.\n------------>");
                        player.getMainTowerList().remove(randomTower);
                        break;
                    }
                default:
                    break;
            }
            round = player.getCurrentRound();
            failCount = 0;
            if (player.getRound() != player.getRounds()) {
                for (int i=0;i<round.getResultCartList().size(); i++) {
                    if (round.getResultCartList().get(i).getFillLevel()<round.getResultCartList().get(i).getCapacity()) {
                        failCount++;
                    }
                }
                if (failCount == 0) {
                    success();
                } else {
                    fail();
                }
            } else {
                endGame();
            }
        }
    }
}
