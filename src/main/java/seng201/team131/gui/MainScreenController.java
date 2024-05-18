package seng201.team131.gui;

import seng201.team131.Player;

public class MainScreenController extends Controller {
    private Player player;
    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    public MainScreenController(Player thePlayer) {
        player = thePlayer;
    }
}