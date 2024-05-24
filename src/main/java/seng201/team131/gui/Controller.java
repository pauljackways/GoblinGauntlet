package seng201.team131.gui;

/**
 * Abstract class that requires controllers to have setplayer function, given FXML automatically calls initialize before giving a chance or player to be set
 */
import seng201.team131.Player;
/**
 * Because javaFX calls initialize first, each controller class that requires player must confirm that player is not null before initialization can continue. Having a setPlayer function enforced avoids such errors, so long as initialize has if(player != null){ as its first line.
 */
public abstract class Controller {
    public abstract void setPlayer(Player player);
}
