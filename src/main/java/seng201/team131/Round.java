package seng201.team131;

import java.util.ArrayList;
import java.util.List;
import static seng201.team131.EnumResources.*;

public class Round {
    private Integer Distance;
    private Integer cartCount;
    private Float moneyThisRound;
    private List<cart> carts;
    private Integer cartCapacity;
    private Integer speed;


    public Round() {
        // Initialize the list
        carts = new ArrayList<>();
    }


    public void applyDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                this.Distance = 5;
                this.cartCount = 5;
                cartCapacity = 5;
                speed = 5;
                break;

            case MEDIUM:
                this.Distance = 10;
                this.cartCount = 10;
                cartCapacity = 10;
                speed = 10;
                break;

            case HARD:
                this.Distance = 15;
                this.cartCount = 15;
                cartCapacity = 15;
                speed = 15;
                break;
        }

        for (int i = 0; i < this.cartCount; i++) {
            cart newCart = new cart();
            carts.add(newCart);

            newCart.setCapacity(cartCapacity); // Example value
            newCart.setResourceType(GOO); // Example resource type
            newCart.setSpeed(speed); // Example speed
            newCart.setFillLevel(0); 
        }
        
    }

    public static void main(String[] args) {
        Round round = new Round();
        round.applyDifficulty(Difficulty.EASY);
        round.applyDifficulty(Difficulty.MEDIUM);
        round.applyDifficulty(Difficulty.HARD);
    }
}



