package seng201.team131.gui;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.util.Duration;
import seng201.team131.*;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import seng201.team131.Round;
import seng201.team131.Selectable;
import seng201.team131.Tower;

public class MainScreenController extends Controller {
    private Player player;
    private List<Cart> cartListSaved = new ArrayList<>();
    private ScheduledExecutorService towerExecutorService;
    private Integer currentCart = 0;
    private ScheduledExecutorService executorService;
    public MainScreenController() {
        //Free Xylophone Music Lessons
    }
    private List<Cart> cartList = new ArrayList<>();
    private ObservableList<Cart> observableList;
    private List<ImageView> ImgViewList = new ArrayList<>();
    private List<Tower> towerList = new ArrayList<>();

    @FXML
    private ListView<Cart> LstMain = new ListView<>();

    @FXML
    private ImageView ImgTwr1;
    @FXML
    private ImageView ImgTwr2;
    @FXML
    private ImageView ImgTwr3;
    @FXML
    private ImageView ImgTwr4;
    @FXML
    private ImageView ImgTwr5;
    private Round thisRound;
    private ObservableList<Cart> observableCartList;

    public void onImgTwr1() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(0));
        }

    }
    @FXML
    public void onImgTwr2() {
        if (player != null){
            player.setSelected((Selectable) towerList.get(1));
        }

    }
    @FXML
    public void onImgTwr3() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(2));

        }

    }
    @FXML
    public void onImgTwr4() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(3));
}

    }
    @FXML
    public void onImgTwr5() {
        if (player != null) {
            player.setSelected((Selectable) towerList.get(4));
        }
    }
    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    public void manageCarts() {
        Platform.runLater(() -> {
            currentCart++;
            if (currentCart <= thisRound.getCartCount()) {
                cartList.add(0, new Cart(player.getFavourResource(), thisRound.getCartCapacity()));
                observableCartList.add(0, cartList.get(0));
            } else {
                observableCartList.add(0, new Cart(0f));
            }
            if (currentCart > 18) {
                if (!observableCartList.isEmpty()) {
                    observableCartList.remove(observableCartList.size()-1);
                }
            }
            if (currentCart > cartList.size() + 18) {
                towerExecutorService.shutdownNow();
                executorService.shutdownNow();
                System.out.println("Done");
                thisRound.setResultCartList(cartList);
                player.setCurrentRound(thisRound);
                player.launchEndScreen(thisRound);
            }
            LstMain.setItems(observableCartList);
        });
    }
    public void manageTowers(Tower tower) {
        Platform.runLater(() -> {
            int twrI = 0;
            int matchCount = tower.getCarts();
            for (int i=0; i<cartList.size(); i++) {
                if (cartList.get(i).getFillLevel() < cartList.get(i).getCapacity()) {
                    EnumResources cartResource = cartList.get(i).getResourceType();
                    if (tower.getResources().contains(cartResource)) {
                        cartList.get(i).fill((float) (cartResource.getFlowFactor() * tower.getValue()));
                        for (twrI = 0; twrI< towerList.size(); twrI++) {
                            if (towerList.get(twrI) == tower) {
                                Glow glow = new Glow();
                                glow.setLevel(0.8);
                                ImgViewList.get(twrI).setEffect(glow);
                                break;
                            }
                        }
                        if (--matchCount == 0) {
                            break;
                        }
                    }
                }
            }
            PauseTransition pause = new PauseTransition(Duration.millis(200));
            int finalTwrI = twrI;
            pause.setOnFinished(event -> ImgViewList.get(finalTwrI).setEffect(null));
            pause.play();
        });
    }
    @FXML
    public void initialize() {
        if (player != null) {
            player.launchInfoPane();
            ImgViewList.addAll(List.of(ImgTwr1, ImgTwr2, ImgTwr3, ImgTwr4, ImgTwr5));
            thisRound = new Round(player.getRound(), player.getMainTowerList());
            thisRound.applyDifficulty(player.getDifficulty());
            thisRound.applyTradeOff(player.getTradeOff());
            thisRound.applyPowerUp(player.getPowerUp());
            towerList = thisRound.getTowers();
            for (int i=0; i<towerList.size(); i++) {
                ImgViewList.get(i).setImage(new Image(towerList.get(i).getImage()));
            }
            observableCartList = FXCollections.observableArrayList(cartList);
            executorService = Executors.newSingleThreadScheduledExecutor();
            towerExecutorService = Executors.newScheduledThreadPool(thisRound.getTowers().size());
            for (Tower tower : thisRound.getTowers()) {
                final Tower currentTower = tower; // lambda expression to pass tower as parameter
                towerExecutorService.scheduleAtFixedRate(() -> manageTowers(currentTower), 1000, tower.getReload(), TimeUnit.MILLISECONDS);            }
            executorService.scheduleAtFixedRate(this::manageCarts, 500, thisRound.getSpeed(), TimeUnit.MILLISECONDS);

        }
    }
}