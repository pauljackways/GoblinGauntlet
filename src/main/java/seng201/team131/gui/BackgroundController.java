package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.layout.Pane;
import seng201.team131.Player;
import java.lang.reflect.InvocationTargetException;

import java.io.IOException;
import java.lang.reflect.Method;

public class BackgroundController extends Controller {

    @FXML
    private Pane PaneLeft;

    @FXML
    private Pane PaneMain;

    @FXML
    private Pane PaneRight;

    private Player player;
    
    public BackgroundController() {
    }
    public BackgroundController(Player player) {
        this.player = player;
    }
    public void initialize() {
        this.player.setBackgroundController(this);
        player.launchSetupScreen();
    }
    public void loadColumn(int columnIndex, String fxmlFile, Class<?> controllerClass, Player player) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent pane = loader.load();
            Object controller = loader.getController();
            Method setPlayerMethod = controllerClass.getMethod("setPlayer", Player.class);
            if (setPlayerMethod != null) {
                setPlayerMethod.invoke(controller, player);
            }

            switch (columnIndex) {
                case 0:
                    PaneLeft.getChildren().setAll(pane);
                    break;
                case 1:
                    PaneMain.getChildren().setAll(pane);
                    break;
                case 2:
                    PaneRight.getChildren().setAll(pane);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column index: " + columnIndex);
            }
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public void clearColumn(int columnIndex) {
        switch (columnIndex) {
            case 0:
                PaneLeft.getChildren().clear();
                break;
            case 1:
                PaneMain.getChildren().clear();
                break;
            case 2:
                PaneRight.getChildren().clear();
                break;
            default:
                throw new IllegalArgumentException("Invalid column index: " + columnIndex);
        }
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
}