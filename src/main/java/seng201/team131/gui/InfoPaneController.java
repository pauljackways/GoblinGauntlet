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

/**
 * An executor-polled class for getting and displaying information from a Selectable object passed to setSelected. Applied to the third column of BackgroundController
 */
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
    /**
     * An executor that effectively polls all relevant fields for the given item of type Selectable
     */
    private void startPeriodicUpdate() {
        executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.scheduleAtFixedRate(this::updateInfo, 0, 500, TimeUnit.MILLISECONDS);
    }
    /**
     * Starts executor for polling player information
     */
    @FXML
    public void initialize() {
        if (player != null) {
            startPeriodicUpdate();
            updateInfo();
        }
    }
    /**
     * Gets player information and displays it in the pane
     */
    private void updateInfo() {
        Platform.runLater(() -> {
            if (player.getSelected() != null) {
                LblName.setText(player.getSelected().getName());
                LblDescription.setText(player.getSelected().getDescription());
                ImgInfo.setImage(new Image(player.getSelected().getImage()));
            } else {
                LblName.setText(null);
                ImgInfo.setImage(null);
                LblDescription.setText("");
            }
        });
    }
}