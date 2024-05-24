package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.layout.Pane;
import seng201.team131.Player;
import java.lang.reflect.InvocationTargetException;

import java.io.IOException;
import java.lang.reflect.Method;
/**
 * Class for controlling the underlying structural FXML for which other FXML pages are laid upon
 */
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
    /**
     * Controller for the underlying structure of the application. Allows for multiple FXML files to be laid on top of it such that dynamic updates may occue without having to duplicated FXML code.
     */
    public BackgroundController(Player player) {
        this.player = player;
    }
    public void initialize() {
        this.player.setBackgroundController(this);
        player.launchSetupScreen();
    }
    /**
     * Updates a particular column of the structure with another FXML document. This section was helped significantly by chatGPT, as our understanding of how JavaFX works under the hood was lacking. Have added setPlayer as a required method to ensure that player can be added. Due to JavaFX calling initialize first, if(player != null) has to be added to every controller that is applied to backgroundController. That way player is null errors cannot occur.
     */
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

    /**
     * Clears the column of its attached FXML file. This was aided by chatGPT as mentioned in the Javadoc for loadColumn.
     */
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