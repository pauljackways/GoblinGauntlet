package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import seng201.team131.Player;
import java.lang.reflect.InvocationTargetException;

import java.io.IOException;
import java.lang.reflect.Method;

public class BackgroundController {

    @FXML
    private Pane PaneLeft;

    @FXML
    private Pane PaneMain;

    @FXML
    private Pane PaneRight;

    private Player player;

    public BackgroundController(Player player) {
        this.player = player;
    }
    public BackgroundController() {
    }
    public void initialize() {
        this.player.setBackgroundController(this);
        SetupScreenController setupController = new SetupScreenController();
        loadColumn(1, "/fxml/setup_screen.fxml", setupController.getClass(), this.player);    }
    public void loadColumn(int columnIndex, String fxmlFile, Class<?> controllerClass, Player player) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent pane = loader.load();
            // Retrieve the controller instance created by FXMLLoader
            Object controller = loader.getController();
            // Check if the controller class has a method to accept the player object
            Method setPlayerMethod = controllerClass.getMethod("setPlayer", Player.class);
            if (setPlayerMethod != null) {
                // Invoke the method to set the player object
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
}