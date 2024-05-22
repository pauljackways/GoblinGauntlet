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
    private Button BtnEnd;
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
    public void onBtnEnd() {

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
        ImgEnd.setImage(new Image("images/fail.jpeg"));
        if (player.getMoney() < 0 && failCount > 0) {
            LblOutcome.setText("You're in debt AND you're missing deliveries? How are you going to get out of this one?");
            ImgEnd.setImage(new Image("images/both.jpeg"));
            switch(random.nextInt(6)) {
                case 0:
                    excuse = "\"Hey, what's that over there!?\" - then run";
                    break;
                case 1:
                    excuse = "Wave your hand and say \"This is not the goblin you're looking for\"";
                    break;
                case 2:
                    excuse = "\"Did you hear what the other guy said about your mother?\nIt was really mean..\"";
                    break;
                case 3:
                    excuse = "Plead and beg and cry";
                    break;
                case 4:
                    excuse = "POCKET SAND";
                    break;
                case 5:
                    excuse = "Turn 360 degrees and run away";
                    break;
            }
            player.loseLife();
            if (player.getLives() > 0) {
                player.loseLife();
            } else {
                endGame();
            }
        } else if (failCount > 0) {
            LblOutcome.setText("Not all carts were filled.\nWithout an excuse, your grave may just be filled...");
            ImgEnd.setImage(new Image("images/fail.jpeg"));
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
            player.loseLife();
        } else {
            LblOutcome.setText("You're in debt. This is the debt collector by the way.\nHave you anything to say?");
            ImgEnd.setImage(new Image("images/collector.jpeg"));
            switch(random.nextInt(6)) {
                case 0:
                    excuse = "\"I'll pay you tomorrow, I swear on my left tail\"";
                    break;
                case 1:
                    excuse = "Write I.O.U on a piece of paper";
                    break;
                case 2:
                    excuse = "\"My apologies, gentlemen.\nI will engage in meditation and self-reflection over this.\"";
                    break;
                case 3:
                    excuse = "\"I'd love to stay and chat, but I have to go now\"";
                    break;
                case 4:
                    excuse = "\"We're all just atoms when you think about it\"";
                    break;
                case 5:
                    excuse = "Cut out one of your kidneys. (you still have a few left)";
                    break;
            }
            player.loseLife();
        }
        if (player.getLives() <= 0) {
            endGame();
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
        LblDmg.setVisible(false);
        player.setSelected(null);
        BtnExcuse.setVisible(false);
        BtnEnd.setVisible(true);
        if (failCount > 0 && player.getMoney() < 0) {
            LblOutcome.setText("The debt collector and the wizard\nhave become very close\nhaving to deal with your incompetence.\nTo celebrate their developing romance\nthey are having a candlelit date\nwhere the main course is your corpse.\n<3");
            ImgEnd.setImage(new Image("images/eat.jpeg"));

        } else if (failCount > 0) {
            LblOutcome.setText("You can't seem to be able to completely fill a train of resources\nnow a train full of resources is going\nto completely kill you...");
            ImgEnd.setImage(new Image("images/debt-5.jpeg"));

        } else if (player.getMoney() < 0) {
            LblOutcome.setText("You owe Morphlin the Wizard a lot money on all those towers\nso Morphlin has turned you into an Ether Crystal tower\nand will sell you at a market rate.\nWill you ever get turned back?\ndoubt it...");
            ImgEnd.setImage(new Image("images/wizard.jpeg"));

        } else {
            LblOutcome.setText("You did it! you made it out of Goblinville\nNow you will go to fancy goblin college\nand get a fancy goblin degree\nso you can do a fancy goblin job\nfor a fancy goblin forever.\n");
            ImgEnd.setImage(new Image("images/win.jpeg"));

        }
        calculateInfo();
    }
    @FXML
    public void initialize() {
        if (player != null) {
            BtnEnd.setVisible(false);
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
                        player.setSelected(player.getMainTowerList().get(randomTower));
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
                if (failCount > 0 || player.getMoney() < 0) {
                    fail();
                } else {
                    success();
                }
            } else {
                endGame();
            }
        }
    }
}
