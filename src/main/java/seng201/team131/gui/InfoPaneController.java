package seng201.team131.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng201.team131.Player;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InfoPaneController extends Controller {

    @FXML
    private ImageView ImgInfo;

    @FXML
    private Label LblName;

    @FXML
    private Label LblDescription;
    private Player player;
    private ScheduledExecutorService executorService2;


    public InfoPaneController() {
        // can we FX it?
    }
    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    private void startPeriodicUpdate() {
        executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.scheduleAtFixedRate(this::updateInfo, 0, 1, TimeUnit.SECONDS);
    }
    @FXML
    public void initialize() {
        if (player != null) {
            startPeriodicUpdate();
            updateInfo();
        }
    }
    private void updateInfo() {
        Platform.runLater(() -> {
            if (player.getSelected() != null) {
                LblDescription.setText(player.getSelected().getDescription());
                ImgInfo.setImage(new Image(player.getSelected().getImage()));
            } else {
                ImgInfo.setImage(null);
                LblDescription.setText("");
            }
        });
    }
}