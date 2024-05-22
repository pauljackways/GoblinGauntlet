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
    private Float moneyPerFillLevel = 10.0f;
    private Random random; 

    public Round(Integer roundNumber) {
        random = new Random();
        this.roundNumber = roundNumber;
        this.cartCount = roundNumber;
    }
  
    public void applyDifficulty(EnumGamechangers difficulty) {
        switch (difficulty) {
            case EASY:
                this.cartCount = 5 * roundNumber;
                cartCapacity = 5.0f;
                speed = 2400;
                break;
            case MEDIUM:
                this.cartCount = 10 * roundNumber;
                cartCapacity = 10.0f;
                speed = 2000;
                break;
            case HARD:
                this.cartCount = 15 * roundNumber;
                cartCapacity = 15.0f;
                speed = 1600;
                break;
            default:
                break;
        }
    }

    public void applyTradeOff(EnumGamechangers tradeOff) {
        switch (tradeOff) {
            case FAST:
                speed -= 400;
                moneyPerFillLevel = moneyPerFillLevel * 1.2f;
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

    public void applyPowerUp(EnumGamechangers powerUp) {
        if (powerUp != null) {
            switch (powerUp) {
                case SLOW:
                    this.speed += 400;
                    break;


                case MONEY:
                    moneyPerFillLevel = moneyPerFillLevel * 1.2f;
                    break;
                default:
                    break;
            }
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
