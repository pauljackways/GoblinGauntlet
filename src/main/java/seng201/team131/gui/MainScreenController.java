package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import seng201.team131.Player;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import seng201.team131.Round;
import seng201.team131.Selectable;
import seng201.team131.Tower;

import java.util.ArrayList;
import java.util.List;

public class MainScreenController extends Controller {
    private Player player;
    public MainScreenController() {
        //Free Xylophone Music Lessons
    }
    private List<ImageView> ImgViewList = new ArrayList<>();
    private List<Tower> towerList = new ArrayList<>();

    @FXML
    private ListView<?> LstMain;

    @FXML
    private ImageView ImgTwr1;
    @FXML
    private ImageView ImgTwr2;
    @FXML
    private ImageView ImgTwr3;
    @FXML
    private ImageView ImgTwr4;
    @FXML
    private ImageView ImgTwr5;
    private Round thisRound;
    public void onImgTwr1() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(0));
        }

    }
    @FXML
    public void onImgTwr2() {
        if (player != null){
            player.setSelected((Selectable) towerList.get(1));
        }

    }
    @FXML
    public void onImgTwr3() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(2));

        }

    }
    @FXML
    public void onImgTwr4() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(3));
}

    }
    @FXML
    public void onImgTwr5() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(4));
        }
    }
    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    @FXML
    public void initialize() {
        if (player != null) {
            player.launchInfoPane();
            ImgViewList.addAll(List.of(ImgTwr1, ImgTwr2, ImgTwr3, ImgTwr4, ImgTwr5));
            towerList = player.getMainTowerList();
            for (int i=0; i<towerList.size(); i++) {
                ImgViewList.get(i).setImage(new Image(towerList.get(i).getImage()));
            }
            thisRound = new Round(player.getRound());
            thisRound.setTowers(player.getMainTowerList());
            thisRound.applyDifficulty(player.getDifficulty());
            thisRound.applyTradeoff(player.getTradeOff());
            thisRound.applyPowerUp(player.getPowerUp());
        }
    }
}