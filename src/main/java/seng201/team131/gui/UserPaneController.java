package seng201.team131.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import seng201.team131.Player;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserPaneController extends Controller{
    private Player player;
    @FXML
    private ImageView ImgUser;
    @FXML
    private Button BtnBack;
    @FXML
    private Label LblName;
    @FXML
    private Label LblRound;
    @FXML
    private Label LblLives;
    @FXML
    private Label LblTowers;
    @FXML
    private Label LblItems;
    @FXML
    private Label LblMoney;
    private ScheduledExecutorService executorService;
    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    private void startPeriodicUpdate() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::updatePlayerInfo, 0, 500, TimeUnit.MILLISECONDS);
    }
    @FXML
    public void initialize() {
        if (player != null) {
            setUserImage(new Image(player.getPfp()));
            startPeriodicUpdate();
            updatePlayerInfo();
        }
    }
    private void updatePlayerInfo() {
        Platform.runLater(() -> {
            setLblName(player.getName());
            setLblItems(Integer.toString(player.getItemList().size()));
            setLblMoney(player.getMoney().toString());
            if (player.getMoney() < 0) {
                LblMoney.setTextFill(Color.RED);
            }
            setLblLives(player.getLives().toString());
            setLblTowers(Integer.toString(player.getReserveTowerList().size() + player.getMainTowerList().size()));
            setLblRound(player.getRound().toString() + " of " + player.getRounds().toString());
            if (player.getfParent()) {
                BtnBack.setVisible(false);
            } else {
                BtnBack.setVisible(true);
            }
        });
    }
    @FXML
    private void onBack() {
        this.player.launchParentScreen();
    }
    public UserPaneController() {
        // FXLoad this up ya
    }
    public void setUserImage(Image image) {
        ImgUser.setImage(image);
    }
    public void setLblRound(String round) {
        LblRound.setText(round);
    }
    public void setLblName(String name) {
        LblName.setText(name);
    }


    public void setLblLives(String lives) {
        LblLives.setText(lives);
    }

    public void setLblTowers(String towers) {
        LblTowers.setText(towers);
    }

    public void setLblItems(String items) {
        LblItems.setText(items);
    }
    public void setLblMoney(String money) {
        LblMoney.setText("$" + money);
    }

}