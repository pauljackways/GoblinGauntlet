package seng201.team131;

//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import seng201.team131.Player;
import java.util.Random;

import static seng201.team131.EnumGamechangers.*;
import static seng201.team131.EnumResources.*;

public class Round {
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
    private Double moneyPerCart;
    private Integer distance;
    private Boolean SABOTAGE;



    private Random random; 

    public Round(Integer round) {
        carts = new ArrayList<>();
        favourResource = 2;
        random = new Random();

    }
    public Round() {

    }
  
    public void applyDifficulty(EnumGamechangers difficulty) {

        //int roundNumber = player.getRound();
        switch (difficulty) {
            case EASY:
                this.cartCount = 5;
                cartCapacity = 5;
                speed = 5;

                break;

            case MEDIUM:
                this.cartCount = 10;
                cartCapacity = 10;
                speed = 10;
                break;

            case HARD:
                this.cartCount = 15;
                cartCapacity = 15;
                speed = 15;
                break;
            default:
                break;
        }

        for (int i = 0; i < this.cartCount; i++) {
            Cart newCart = new Cart();
            carts.add(newCart);
            newCart.setCapacity(cartCapacity);
            newCart.setFillLevel(0);
            Random random = new Random();
            int randomResouce = random.nextInt(3);
            if(randomResouce == 0){newCart.setResourceType(LAVA);}
            if(randomResouce == 1){newCart.setResourceType(ETHER);}
            if(randomResouce == 2){newCart.setResourceType(GOO);}
        }
    }

    public void applyTradeOff(EnumGamechangers tradeOff) {
        switch (tradeOff) {
            case FAST:
                for (int i = 0; i < this.cartCount; i++) {
//                    carts.get(i).setSpeed(carts.get(i).getSpeed()*1.2);
                }
                moneyPerCart = moneyPerCart * 1.2;
                break;

            case SABOTAGE:
                int randomTower = random.nextInt(towerList.size());
                towerList.remove(randomTower);

            case THEFT:
                //ADD flow rate change
            default:
                break;
        }
    }

    public void applyPowerUp(EnumGamechangers pwrUp) {
        switch (pwrUp) {
            case SLOW:
                for (int i = 0; i < this.cartCount; i++) {
//                    carts.get(i).setSpeed(carts.get(i).getSpeed()*0.8);
                }
                break;


            case MONEY:
                for (int i = 0; i < this.cartCount; i++) {
                    moneyPerCart = moneyPerCart * 1.2;
                }
                break;

            case DISTRIBUTION:
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


                if (randomValue < chanceETHER) {
                    //newCart.setResourceType(ETHER);
                } else if (randomValue < chanceETHER + chanceLava) {
                    //newCart.setResourceType(LAVA);
                } else {
                    //newCart.setResourceType(GOO);
                }

                //System.out.println(newCart.getAllAttributes());
                break;
            default:
                break;
        }
    }

    public void setTowers(List<Tower> towerList) {
        this.towerList = towerList;
    }
    public List<Tower> getTowers() {
        return towerList;
    }

    public List<Cart> getCarts() {
        return carts;
    }

}

// round.applyDifficulty(Difficulty.EASY);
// This is the call to get cars of a said difficulty, you then have to call getCarts.
