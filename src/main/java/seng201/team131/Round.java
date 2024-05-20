package seng201.team131;

//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static seng201.team131.EnumResources.*;

public class Round {
    private Integer distance;
    private Integer cartCount;
    private Float moneyThisRound;
    private List<cart> carts;
    private Integer cartCapacity;
    private Integer speed;
    private Integer favourResource;
    

    private Double chanceETHER;
    private Double chanceLava;
    @SuppressWarnings("unused")
    private Double chanceGoo;



    public Round() {
        carts = new ArrayList<>();
        favourResource = 2;
        
    }


    public void applyDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                this.distance = 5;
                this.cartCount = 5;
                cartCapacity = 5;
                speed = 5;
                distance = 5;
                break;

            case MEDIUM:
                this.distance = 10;
                this.cartCount = 10;
                cartCapacity = 10;
                speed = 10;
                distance = 10;
                break;

            case HARD:
                this.distance = 15;
                this.cartCount = 15;
                cartCapacity = 15;
                speed = 15;
                distance = 15;
                break;
        }

        for (int i = 0; i < this.cartCount; i++) {
            cart newCart = new cart();
            carts.add(newCart);
            newCart.setCapacity(cartCapacity); 
            newCart.setSpeed(speed); 
            newCart.setFillLevel(0);
            newCart.setResourceType(GOO);
            Random random = new Random();
            double randomValue = random.nextDouble();

            if(favourResource == 0){
                chanceETHER = 0.6;
                chanceLava = 0.2;
                chanceGoo = 0.2;
            }
            if(favourResource == 1){
                chanceETHER = 0.2;
                chanceLava = 0.6;
                chanceGoo = 0.2;
            }
            if(favourResource == 2){
                chanceETHER = 0.2;
                chanceLava = 0.2;
                chanceGoo = 0.6;
            }


            if (randomValue < chanceETHER) {
                newCart.setResourceType(ETHER);
            } else if (randomValue < chanceETHER + chanceLava) {
                newCart.setResourceType(LAVA);
            } else {
                newCart.setResourceType(GOO);
            }

            
            //System.out.println(randomValue);
            //System.out.println(newCart.getResourceType());
            System.out.println(newCart.getAllAttributes());
            
        }
    }
    
    public List<cart> getCarts() {
        return carts;
    }
        
    
     public static void main(String[] args) {
         Round round = new Round();
         round.applyDifficulty(Difficulty.EASY);
         round.applyDifficulty(Difficulty.MEDIUM);
         round.applyDifficulty(Difficulty.HARD);
     }
}



