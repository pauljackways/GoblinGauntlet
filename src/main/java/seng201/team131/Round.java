package seng201.team131;

import java.util.List;
import java.util.Random;
public class Round {
    private List<Tower> towerList;
    private Integer cartCount;
    private Float moneyThisRound;
    private Integer roundNumber;
    private Float cartCapacity;
    private Integer speed; // milliseconds to travel 10m
    private Double moneyPerCart;
    private Random random; 

    public Round(Integer roundNumber) {
        random = new Random();

    }
  
    public void applyDifficulty(EnumGamechangers difficulty) {
        switch (difficulty) {
            case EASY:
                this.cartCount = 5 * roundNumber;
                cartCapacity = 5.0f;
                speed = 1200;

                break;

            case MEDIUM:
                this.cartCount = 10 * roundNumber;
                cartCapacity = 10.0f;
                speed = 1000;
                break;
            case HARD:
                this.cartCount = 15 * roundNumber;
                cartCapacity = 15.0f;
                speed = 800;
                break;
            default:
                break;
        }
    }

    public void applyTradeOff(EnumGamechangers tradeOff) {
        switch (tradeOff) {
            case FAST:
                for (int i = 0; i < this.cartCount; i++) {
                    speed *= 800;
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
                    this.speed += 1200;
                }
                break;


            case MONEY:
                for (int i = 0; i < this.cartCount; i++) {
                    moneyPerCart = moneyPerCart * 1.2;
                }
                break;
            default:
                break;
        }
    }
    public Integer getSpeed() {
        return speed;
    }
    public Float getCartCapacity() {
        return cartCapacity;
    }
    public Integer getCartCount() {
        return cartCount;
    }
    public void setTowers(List<Tower> towerList) {
        this.towerList = towerList;
    }
    public List<Tower> getTowers() {
        return towerList;
    }
}
