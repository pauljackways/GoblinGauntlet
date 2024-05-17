package seng201.team131;

import seng201.team131.gui.BackgroundController;
import seng201.team131.gui.ParentScreenController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Player {


    public Player(
            Consumer<Player> backgroundLauncher,
            Consumer<Player> setupScreenLauncher,
            Consumer<Player> parentScreenLauncher,
            Consumer<Player> towerScreenLauncher,
            Consumer<Player> shopScreenLauncher,
            Consumer<Player> gameChangersScreenLauncher,
            Consumer<Player> mainScreenLauncher,
            Consumer<Player> endScreenLauncher,
            Runnable clearScreen) {
        this.backgroundLauncher = backgroundLauncher;
        this.setupScreenLauncher = setupScreenLauncher;
        this.parentScreenLauncher = parentScreenLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.gameChangersScreenLauncher = gameChangersScreenLauncher;
        this.endScreenLauncher = endScreenLauncher;
        this.mainScreenLauncher = mainScreenLauncher;
        this.clearScreen = clearScreen;
        this.name = "Smith";
        this.defaultTowers.addAll(List.of(new Tower("Mystery tower")));
        launchBackground();
    }
    private BackgroundController controller;

    private String name;
    private List<Tower> towerList;
    private final List<Tower> defaultTowers = new ArrayList<>();
    private final Consumer<Player> backgroundLauncher;
    private final Consumer<Player> setupScreenLauncher;
    private final Consumer<Player> parentScreenLauncher;
    private final Consumer<Player> shopScreenLauncher;
    private final Consumer<Player> towerScreenLauncher;
    private final Consumer<Player> gameChangersScreenLauncher;
    private final Consumer<Player> endScreenLauncher;
    private final Consumer<Player> mainScreenLauncher;
    private final Runnable clearScreen;

    public void launchBackground() {
        backgroundLauncher.accept(this);
    }
    public void launchSetupScreen() {
        setupScreenLauncher.accept(this);
    }

    public void closeSetupScreen() {
        controller.clearColumn(1);
        launchParentScreen();
    }

    public void setBackgroundController(BackgroundController controller) {
        this.controller = controller;
    }

    public void launchParentScreen() {
        // Make sure the controller is set before invoking methods that depend on it
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/parent_screen.fxml", ParentScreenController.class, this);
        }
        // Continue with other actions related to launching the parent screen
        parentScreenLauncher.accept(this);
    }

    public void launchShopScreen() {
        clearScreen.run();
        shopScreenLauncher.accept(this);
    }

    public void closeShopScreen() {}

    public void launchTowerScreen() {
        towerScreenLauncher.accept(this);
    }

    public void closeTowerScreen() {}

    public void launchGameChangersScreen() {
        clearScreen.run();
        gameChangersScreenLauncher.accept(this);
    }

    public void closeGameChangersScreen() {}

    public void launchEndScreen() {
        endScreenLauncher.accept(this);
    }

    public void closeEndScreen() {}

    public void launchMainScreen() {
        mainScreenLauncher.accept(this);
    }

    public void closeMainScreen() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tower> getTowerList() {
        return towerList;
    }

    public void addTower(Tower tower) {
        this.towerList.add(tower);
    }

    public List<Tower> getDefaultRockets() {
        return defaultTowers;
    }
}