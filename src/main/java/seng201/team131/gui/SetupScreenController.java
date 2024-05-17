package seng201.team131.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seng201.team131.services.CounterService;
import seng201.team131.Player;

public class SetupScreenController {
    private Player player;

    public SetupScreenController(Player newPlayer) {
        player = newPlayer;
    }
    public void initialize() {

    }
}
