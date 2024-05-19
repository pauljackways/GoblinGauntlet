package seng201.team131;

import seng201.team131.gui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Player {
    public Player(
            Consumer<Player> backgroundLauncher,
            Consumer<Player> userPaneLauncher,
            Consumer<Player> setupScreenLauncher,
            Consumer<Player> parentScreenLauncher,
            Consumer<Player> towerScreenLauncher,
            Consumer<Player> shopScreenLauncher,
            Consumer<Player> gameChangersScreenLauncher,
            Consumer<Player> mainScreenLauncher,
            Consumer<Player> endScreenLauncher,
            Runnable clearScreen) {
        this.backgroundLauncher = backgroundLauncher;
        this.userPaneLauncher = userPaneLauncher;
        this.setupScreenLauncher = setupScreenLauncher;
        this.parentScreenLauncher = parentScreenLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.gameChangersScreenLauncher = gameChangersScreenLauncher;
        this.endScreenLauncher = endScreenLauncher;
        this.mainScreenLauncher = mainScreenLauncher;
        this.clearScreen = clearScreen;
        this.name = "Smith";
        this.resources = new ResourceType[]{new ResourceType("Gremlin Goo", 1), new ResourceType("Lava", 1), new ResourceType("Ether Crystals", 1)};
        this.defaultTowers.addAll(List.of(new Tower(this.resources[0], "Small Gremlin Grinder", "images/goblin1.jpeg"), new Tower(this.resources[1], "Small Lava well", "images/goblin2.jpeg"), new Tower(this.resources[2], "Small Crystal Crucible", "images/goblin3.jpeg")));
        this.mainTowerList.addAll(List.of(new Tower(this.resources[0], "Small Gremlin Grinder", "images/goblin1.jpeg"), new Tower(this.resources[1], "Small Lava well", "images/goblin2.jpeg"), new Tower(this.resources[2], "Small Crystal Crucible", "images/goblin3.jpeg")));
        this.reserveTowerList.addAll(List.of(new Tower(this.resources[0], "Small Gremlin Grinder", "images/goblin1.jpeg"), new Tower(this.resources[1], "Small Lava well", "images/goblin2.jpeg"), new Tower(this.resources[2], "Small Crystal Crucible", "images/goblin3.jpeg")));

        launchBackground();

    }
    private BackgroundController controller;
    private String name;
    private ResourceType[] resources = new ResourceType[3];
    private List<Tower> mainTowerList = new ArrayList<>();
    private List<Tower> reserveTowerList = new ArrayList<>();
    private String pfp;
    private int rounds;
    private final List<Tower> defaultTowers = new ArrayList<>();
    private final Consumer<Player> backgroundLauncher;
    private final Consumer<Player> userPaneLauncher;
    private final Consumer<Player> setupScreenLauncher;
    private final Consumer<Player> parentScreenLauncher;
    private final Consumer<Player> shopScreenLauncher;
    private final Consumer<Player> towerScreenLauncher;
    private final Consumer<Player> gameChangersScreenLauncher;
    private final Consumer<Player> endScreenLauncher;
    private final Consumer<Player> mainScreenLauncher;
    private final Runnable clearScreen;

    public void sell(Tower tower) {

    }
    public void buy(Tower tower) {

    }
    public void launchBackground() {
        backgroundLauncher.accept(this);
    }
    public void setBackgroundController(BackgroundController controller) {
        this.controller = controller;
    }
    
    public void launchSetupScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/setup_screen.fxml", SetupScreenController.class, this);
        }
        setupScreenLauncher.accept(this);
    }
    public void launchParentScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/parent_screen.fxml", ParentScreenController.class, this);
        }
        parentScreenLauncher.accept(this);
    }
    public void launchShopScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/shop_screen.fxml", ShopScreenController.class, this);
        }
        shopScreenLauncher.accept(this);
    }
    public void launchUserPane() {
        if (controller != null) {
            controller.clearColumn(0);
            controller.loadColumn(0, "/fxml/user_pane.fxml", UserPaneController.class, this);
        }
        userPaneLauncher.accept(this);
    }
    public void launchTowerScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/tower_screen.fxml", TowerScreenController.class, this);
        }
        towerScreenLauncher.accept(this);
    }
    public void launchEndScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/end_screen.fxml", EndScreenController.class, this);
        }
        endScreenLauncher.accept(this);
    }
    public void launchGameChangersScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/game_changers_screen.fxml", GameChangersScreenController.class, this);
        }
        gameChangersScreenLauncher.accept(this);
    }
    public void launchMainScreen() {
        if (controller != null) {
            controller.clearColumn(1);
            controller.loadColumn(1, "/fxml/main_screen.fxml", MainScreenController.class, this);
        }
        mainScreenLauncher.accept(this);
    }
    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    // Getter and setter for rounds
    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public List<Tower> getmainTowerList() {
        return mainTowerList;
    }

    public List<Tower> getReserveTowerList() {
        return reserveTowerList;
    }

    public void addTower(Tower tower) {
        this.mainTowerList.add(tower);
    }

    public List<Tower> getDefaultTowers() {
        return defaultTowers;
    }

}