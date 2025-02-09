package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import seng201.team131.EnumResources;
import seng201.team131.Player;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import seng201.team131.Round;
import seng201.team131.Tower;

import java.util.Random;

import static seng201.team131.EnumGamechangers.*;
/**
 * Screen controller that determines the results of the round and game and displays them to the user
 */
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
    /**
     * The button to continue to the next round
     */
    public void onBtnExcuse() {
        player.setFavorResource(random.nextInt(EnumResources.values().length));
        player.launchParentScreen();
        player.nextRound();
    }
    /**
     * The button that closes the game upon completion
     */
    public void onBtnEnd() {
        System.exit(0);
    }

    /**
     * Calculates round statistics not otherwise found in the UserPane
     */
    public void calculateInfo(){
        if (player.getTradeOff() == FAST || player.getTradeOff() == SABOTAGE) {
            for (int i=0; i<round.getResultCartList().size(); i++) {
                moneyMade += round.getResultCartList().get(i).getFillLevel() * round.getMoneyPerFillLevel();
            }
            moneyMade+= 500;
        } else {
            for (int i=0; i< EnumResources.values().length; i++) {
                EnumResources.values()[i].setFlowFactor(1.0f);
            }
            for (int i=0; i<round.getResultCartList().size(); i++) {
                if (round.getResultCartList().get(i).getResourceType().ordinal() == round.getTheftResource()) {
                    moneyMade += round.getResultCartList().get(i).getFillLevel() * round.getMoneyPerFillLevel() * 1.5f;
                } else {
                    moneyMade += round.getResultCartList().get(i).getFillLevel() * round.getMoneyPerFillLevel();
                }
            }
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
    /**
     * Called when the user has failed a round due to carts being missed, or debt remaining after round payout
     */
    public void fail() {
        ImgEnd.setImage(new Image("images/fail.jpeg"));
        if (player.getMoney() < 0 && failCount > 0) {
            LblOutcome.setText("You're in debt AND you're missing deliveries?\nHow are you going to get out of this one?");
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
        BtnExcuse.setText(excuse);
        if (player.getLives() <= 0) {
            endGame();
        }
    }
    /**
     * Called after a round when all carts were filled and there is no debt remaining after round payout
     */
    public void success() {
        ImgEnd.setImage(new Image("images/success.jpeg"));
        LblOutcome.setText("A successful delivery. Safe for another day...");
        BtnExcuse.setText("\"Pleasure doing business\"");
    }
    /**
     * Determines which ending the player has reached, given the current round and the number of excuses the player has remaining.
     */
    public void endGame() {
        LblDmg.setVisible(false);
        player.setSelected(null);
        BtnExcuse.setVisible(false);
        BtnEnd.setVisible(true);
        if (failCount > 0 && player.getMoney() < 0 && player.getLives() <= 0) {
            LblOutcome.setText("The debt collector and the wizard\nhave become very close\nhaving to deal with your incompetence.\nTo celebrate their developing romance\nthey are having a candlelit date\nwhere the main course is your corpse.\n<3");
            ImgEnd.setImage(new Image("images/eat.jpeg"));

        } else if (failCount > 0 && player.getLives() <= 0) {
            LblOutcome.setText("You can't seem to be able to completely fill a train of resources\nnow a train full of resources is going\nto completely kill you...");
            ImgEnd.setImage(new Image("images/debt-5.jpeg"));

        } else if (player.getMoney() < 0 && player.getLives() <= 0)  {
            LblOutcome.setText("You owe Morphlin the Wizard a lot money on all those towers\nso Morphlin has turned you into a tower\nand will sell you at a market rate.\nWill you ever get turned back?\ndoubt it...");
            ImgEnd.setImage(new Image("images/wizard.jpeg"));

        } else {
            LblOutcome.setText("You did it! you made it out of Goblinville\nNow you will go to fancy goblin college\nand get a fancy goblin degree\nso you can do a fancy goblin job\nfor a fancy goblin forever.\n");
            ImgEnd.setImage(new Image("images/win.jpeg"));

        }
        calculateInfo();
    }
    /**
     * Determines what informative information and round endings to display after a round
     */
    @FXML
    public void initialize() {
        if (player != null) {
            player.setPowerUp(null);
            player.setFPowerUpBought(false);
            BtnEnd.setVisible(false);
            player.setSelected(null);
            round = player.getCurrentRound();
            failCount = 0;
            for (int i=0;i<round.getResultCartList().size(); i++) {
                if (round.getResultCartList().get(i).getFillLevel()<round.getResultCartList().get(i).getCapacity()) {
                    failCount++;
                }
            }
            calculateInfo();
            if (!player.getMainTowerList().isEmpty()) {
                int randomTower = random.nextInt(player.getMainTowerList().size());
                switch (player.getDifficulty()) {
                    case EASY:
                        if (player.getRound() != 1) {
                            player.setSelected(player.getMainTowerList().get(randomTower));
                            LblDmg.setText("A gremlin has become\nlodged between the on and\noff switch of your tower\nleaving it in a superposition\nof states that has reduced\n efficiency slightly.\n------------>");
                            player.getMainTowerList().get(randomTower).dmgTower();
                        }
                        break;

                    case MEDIUM:
                        if (player.getRound() != 1) {
                            player.setSelected(player.getMainTowerList().get(randomTower));
                            LblDmg.setText("Mainline stream \nglycopump wingnut\nhas been eaten.\nYour tower is damaged.\n------------>");
                            player.getMainTowerList().get(randomTower).dmgTower();
                            player.getMainTowerList().get(randomTower).dmgTower();
                        }
                        break;

                    case HARD:
                        if (random.nextInt(player.getRounds()-player.getRound()+1) <= 2) {
                            player.setSelected(player.getMainTowerList().get(randomTower));
                            LblDmg.setText("Catastrophic disaster.\nMultiple orcslave fatalities.\nYour tower has imploded\nand is no longer.\n------------>");
                            player.getMainTowerList().remove(randomTower);
                            break;
                        }
                    default:
                        break;
                }
            }
            if (player.getRound() < player.getRounds()) {
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
