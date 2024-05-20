package seng201.team131.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import seng201.team131.Player;
public class GameChangersScreenController extends Controller {
    private Player player;
    @FXML
    private ImageView ImgHard;
    @FXML
    public void onBtnBuyPwrUp() {

    }
    @FXML
    private Button BtnBuyPwrUp;
    @FXML
    public void onImgSabo() {

    }
    @FXML
    private ImageView ImgMoney;
    @FXML
    public void onImgMoney() {

    }
    @FXML
    private ImageView ImgDist;
    @FXML
    public void onImgDist() {

    }
    @FXML
    private ImageView ImgFast;
    @FXML
    public void onImgFast() {

    }
    @FXML
    public void onImgHard() {

    }
    @FXML
    private ImageView ImgMed;
    @FXML
    public void onImgMed() {

    }
    @FXML
    private ImageView ImgEasy;
    @FXML
    public void onImgEasy() {

    }
    @FXML
    private ImageView ImgSlow;
    @FXML
    public void onImgSlow() {

    }

    public GameChangersScreenController() {
        //go FX yourself
    }

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

}
