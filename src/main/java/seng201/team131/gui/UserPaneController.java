package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng201.team131.Player;

public class UserPaneController {
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

    @FXML
    private void initialize() {
        // This method is called by the FXMLLoader when initialization is complete
        // Initialize any necessary data or configurations here
    }

    @FXML
    private void onBack() {
        // Handle the back button action here
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
    public void setPlayer(Player player) {
        this.player = player;
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