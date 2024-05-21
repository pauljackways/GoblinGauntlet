package seng201.team131;

//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import seng201.team131.Player;
import java.util.Random;

import static seng201.team131.EnumResources.*;

public class Round {
    private Integer cartSpeed;
    private List<Tower> towerList;
    private Integer cartCount;
    private Float moneyThisRound;
    private List<Cart> carts;
    private Integer cartCapacity;
    private Integer speed;
    private Integer favourResource;
    private Integer currentRound;
    private Integer round;
    private Double chanceETHER;
    private Double chanceLava;
    private Double chanceGoo;
    private EnumGamechangers difficulty;
    private EnumGamechangers tradeOff;
    private EnumGamechangers powerUp;

    private Random random; 

    public Round(Integer round) {
        //this.round = round; // Store the player instance
        carts = new ArrayList<>();
        favourResource = 2; // is to be changed based on the prompt given to the user
        random = new Random(); // Initialize the random variable
    }
    public Round() {

    }
  
    public void applyDifficulty(EnumGamechangers difficulty) {

        //int roundNumber = player.getRound();
        switch (difficulty) {
            case EASY:
                this.cartSpeed = 5;
                this.cartCount = 5;
                cartCapacity = 5;
                speed = 5;
                cartSpeed = 5;
                break;

            case MEDIUM:
                this.cartSpeed = 10;
                this.cartCount = 10;
                cartCapacity = 10;
                speed = 10;
                cartSpeed = 10;
                break;

            case HARD:
                this.cartSpeed = 15;
                this.cartCount = 15;
                cartCapacity = 15;
                speed = 15;
                cartSpeed = 15;
                break;
        }

        for (int i = 0; i < this.cartCount; i++) {
            Cart newCart = new Cart();
            carts.add(newCart);
            newCart.setCapacity(cartCapacity);
            newCart.setSpeed(speed);
            newCart.setFillLevel(0);
            newCart.setResourceType(GOO);
            double randomValue = random.nextDouble();

            if (favourResource == 0) {
                chanceETHER = 0.6;
                chanceLava = 0.2;
                chanceGoo = 0.2;
            }
            if (favourResource == 1) {
                chanceETHER = 0.2;
                chanceLava = 0.6;
                chanceGoo = 0.2;
            }
            if (favourResource == 2) {
                chanceETHER = 0.2;
                chanceLava = 0.2;
                chanceGoo = 0.6;
            }
            if (favourResource == 3) {
                chanceETHER = 0.3333;
                chanceLava = 0.3333;
                chanceGoo = 0.3333;
            }

            if (randomValue < chanceETHER) {
                newCart.setResourceType(ETHER);
            } else if (randomValue < chanceETHER + chanceLava) {
                newCart.setResourceType(LAVA);
            } else {
                newCart.setResourceType(GOO);
            }

            System.out.println(newCart.getAllAttributes());
        }
    }

    public void setTowers(List<Tower> towerList) {
        this.towerList = towerList;
    }

    public List<Cart> getCarts() {
        return carts;
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
}

// round.applyDifficulty(Difficulty.EASY);
// This is the call to get cars of a said difficulty, you then have to call getCarts.
