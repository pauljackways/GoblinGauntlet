package seng201.team131;

import seng201.team131.gui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import static seng201.team131.EnumItems.*;
import static seng201.team131.EnumResources.*;


public class Player {
    public Player(
            Consumer<Player> backgroundLauncher,
            Consumer<Player> userPaneLauncher,
            Consumer<Player> setupScreenLauncher,
            Consumer<Player> parentScreenLauncher,
            Consumer<Player> infoPaneLauncher,
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
        this.round = 1;
        this.currentRound = new Round(this.getRound());
        this.infoPaneLauncher = infoPaneLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.gameChangersScreenLauncher = gameChangersScreenLauncher;
        this.endScreenLauncher = endScreenLauncher;
        this.mainScreenLauncher = mainScreenLauncher;
        this.clearScreen = clearScreen;
        this.lives = 3;
        this.name = "Smith";
        this.selected = null;
        this.fParent = false;
        this.defaultItems.addAll(List.of(new Item(UPGRADE), new Item(REPAIR)));
        this.defaultTowers.addAll(List.of(new Tower(List.of(GOO),"Small Gremlin Grinder", "images/twrSlime1.jpeg", 1), new Tower(List.of(LAVA),"Small Lava well", "images/twrLava1.jpeg", 1), new Tower(List.of(ETHER),"Small Crystal Crucible", "images/twrEther1.jpeg", 1),
                new Tower(List.of(GOO),"Modest Gremlin Macerator", "images/twrSlime2.jpeg", 3), new Tower(List.of(LAVA),"Modest Magma Spire", "images/twrLava2.jpeg", 3), new Tower(List.of(ETHER),"Modest Crystal Cryochamber", "images/twrEther2.jpeg", 3),
                new Tower(List.of(GOO),"Giant Gore Goliath", "images/twrSlime3.jpeg", 5), new Tower(List.of(LAVA),"Giant Vesuvian Volcanizer", "images/twrLava3.jpeg", 5), new Tower(List.of(ETHER),"Giant Crystal Cascade", "images/twrEther3.jpeg", 5)));
        this.mainTowerList.addAll(List.of(new Tower(List.of(GOO),"Small Gremlin Grinder", "images/twrSlime1.jpeg", 1), new Tower(List.of(LAVA),"Small Lava well", "images/twrLava1.jpeg", 1), new Tower(List.of(ETHER),"Small Crystal Crucible", "images/twrEther1.jpeg", 1)));
        this.money = 500f;
        Random random = new Random();
        this.favorResource = random.nextInt(3);
        launchBackground();
    }
    private List<Item> defaultItems = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    private BackgroundController controller;
    private String name;
    private int favorResource;
    private boolean fParent = false;
    private List<Tower> mainTowerList = new ArrayList<>();
    private List<Tower> reserveTowerList = new ArrayList<>();
    private String pfp;
    private EnumGamechangers difficulty;
    private EnumGamechangers tradeOff;
    private EnumGamechangers powerUp;
    private Integer lives;
    private Float money;
    private Integer rounds;
    private Integer round;
    private Selectable selected;
    private final List<Tower> defaultTowers = new ArrayList<>();
    private final Consumer<Player> backgroundLauncher;
    private final Consumer<Player> userPaneLauncher;
    private final Consumer<Player> setupScreenLauncher;
    private final Consumer<Player> parentScreenLauncher;
    private final Consumer<Player> infoPaneLauncher;
    private final Consumer<Player> shopScreenLauncher;
    private final Consumer<Player> towerScreenLauncher;
    private final Consumer<Player> gameChangersScreenLauncher;
    private final Consumer<Player> endScreenLauncher;
    private final Consumer<Player> mainScreenLauncher;
    private final Runnable clearScreen;
    private Round currentRound;

    public void sell(Sellable item) {
        if (item instanceof Tower) {
            if (mainTowerList.contains(item)) {
                mainTowerList.remove(item);
            }
            else if (reserveTowerList.contains(item)) {
                reserveTowerList.remove(item);
            }
        }
        money += item.getPrice();
    }
    public boolean buy(Buyable item) {
        if (item instanceof Tower) {
            if (mainTowerList.size() < 5) {
                mainTowerList.add((Tower) item);
            } else if (reserveTowerList.size() < 5) {
                reserveTowerList.add((Tower) item);
            } else {
                return false;
            }
        } else if (item instanceof Item) {
            itemList.add((Item) item);
        }else{
            return false;
        }
        money -= item.getCost();
        return true;
    }
    public Integer getLives() {
        return this.lives;
    }
    public boolean getfParent() {
        return this.fParent;
    }
    public Float getMoney() {
        return this.money;
    }
    public void setfParent(boolean flag) {
        this.fParent = flag;
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
    public void launchInfoPane() {
        if (controller != null) {
            controller.clearColumn(2);
            controller.loadColumn(2, "/fxml/info_pane.fxml", InfoPaneController.class, this);
        }
        infoPaneLauncher.accept(this);
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
    public Integer getRound() {
        return round;
    }

    public void setSelected(Selectable selected) {
        this.selected = selected;
    }
    public Selectable getSelected() {
        if (selected == null) {
            return null;
        }
        return selected;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
    
    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public List<Item> getItemList() {
        return itemList;
    }
    public List<Tower> getMainTowerList() {
        return mainTowerList;
    }

    public List<Tower> getReserveTowerList() {
        return reserveTowerList;
    }

    public void setCurrentRounds() {
        this.currentRound = currentRound;
    }

    public Round getCurrentRounds(){
        return currentRound;
    }


    public EnumGamechangers getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(EnumGamechangers difficulty){
        this.difficulty = difficulty;
    }
    public EnumGamechangers getTradeOff(){
        return tradeOff;
    }

    public void setTradeOff(EnumGamechangers tradeOff){
        this.tradeOff = tradeOff;
    }
    public EnumGamechangers getPowerUp(){
        return powerUp;
    }

    public void setPowerUp(EnumGamechangers powerUp){
        this.powerUp = powerUp;
    }

    public List<Tower> getDefaultTowers() {
        return defaultTowers;
    }
    public List<Item> getDefaultItems() {
        return defaultItems;
    }

    public Integer getFavourResource() {
        return favorResource;
    }

    public void setFavorResource(Integer favorResource) {
        this.favorResource = favorResource;
    }

    public void setTradeOffs(EnumGamechangers tradeOff){
        this.tradeOff = tradeOff;
    }

    public EnumGamechangers getTradeOffs(){
        return tradeOff;
    }

    public void clearInfoPane() {
    }
}