package seng201.team131;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Player {

    public Player(
            Consumer<Player> setupScreenLauncher,
            Consumer<Player> parentScreenLauncher,
            Consumer<Player> towerScreenLauncher,
            Consumer<Player> shopScreenLauncher,
            Consumer<Player> gameChangersScreenLauncher,
            Consumer<Player> mainScreenLauncher,
            Consumer<Player> endScreenLauncher,
            Runnable clearScreen) {
        this.setupScreenLauncher = setupScreenLauncher;
        this.parentScreenLauncher = parentScreenLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.gameChangersScreenLauncher = gameChangersScreenLauncher;
        this.endScreenLauncher = endScreenLauncher;
        this.mainScreenLauncher = mainScreenLauncher;
        this.clearScreen = clearScreen;
        this.defaultTowers.addAll(List.of(new Tower("Mystery tower")));
        launchSetupScreen();
    }
    private String name;
    private List<Tower> towerList;
    private final List<Tower> defaultTowers = new ArrayList<>();
    private final Consumer<Player> setupScreenLauncher;
    private final Consumer<Player> parentScreenLauncher;
    private final Consumer<Player> shopScreenLauncher;
    private final Consumer<Player> towerScreenLauncher;
    private final Consumer<Player> gameChangersScreenLauncher;
    private final Consumer<Player> endScreenLauncher;
    private final Consumer<Player> mainScreenLauncher;

    public void launchSetupScreen() {
        setupScreenLauncher.accept(this);
    }

    public void closeSetupScreen() {
        clearScreen.run();
        launchParentScreen();
    }
    public void launchParentScreen() {parentScreenLauncher.accept(this);}
    public void closeParentScreen() {}

    // Method to launch the shop screen
    public void launchShopScreen() {
        shopScreenLauncher.accept(this);
    }

    public void closeShopScreen() {}

    // Method to launch the tower screen
    public void launchTowerScreen() {
        towerScreenLauncher.accept(this);
    }

    public void closeTowerScreen() {}

    // Method to launch the game changers screen
    public void launchGameChangersScreen() {
        gameChangersScreenLauncher.accept(this);
    }

    public void closeGameChangersScreen() {}

    // Method to launch the end screen
    public void launchEndScreen() {
        endScreenLauncher.accept(this);
    }

    public void closeEndScreen() {}

    // Method to launch the main screen
    public void launchMainScreen() {
        mainScreenLauncher.accept(this);
    }

    public void closeMainScreen() {}
    private final Runnable clearScreen;

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