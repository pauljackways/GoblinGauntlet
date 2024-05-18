package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng201.team131.Player;

public class UserPaneController extends Controller{
    private Player player;

    @FXML
    private ImageView ImgUser;

    @FXML
    private Button BtnBack;

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

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    @FXML
    public void initialize() {
        if (player != null) {

        }
    }

    @FXML
    private void onBack() {
        this.player.launchParentScreen();
        System.out.println("Back button clicked");
        // For example, you could load the previous screen
    }
    public UserPaneController() {
        // FXLoad this up ya
    }
    // Method to update the user image
    public void setUserImage(Image image) {
        ImgUser.setImage(image);
    }
    // Methods to update the labels
    public void setRound(String round) {
        LblRound.setText(round);
    }

    public void setLives(String lives) {
        LblLives.setText(lives);
    }

    public void setTowers(String towers) {
        LblTowers.setText(towers);
    }

    public void setItems(String items) {
        LblItems.setText(items);
    }

    public void setMoney(String money) {
        LblMoney.setText(money);
    }

}