package seng201.team131;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Round {
    private List<Tower> towerList;
    private Integer cartCount;
    private List<Cart> resultCartList;
    private Float moneyThisRound;
    private Integer roundNumber;
    private Float cartCapacity = 10f;
    private Integer speed = 1000; // milliseconds to travel 10m
    private Float moneyPerFillLevel = 10.0f;
    private Random random; 

    public Round(Integer roundNumber, List<Tower> playerTowerList) {
        List<Tower> towerList = new ArrayList<>(playerTowerList);
        this.towerList = towerList;
        random = new Random();
        this.roundNumber = roundNumber;
        this.cartCount = roundNumber;
    }
  
    public void applyDifficulty(EnumGamechangers difficulty) {
        switch (difficulty) {
            case EASY:
                this.cartCount = 5 * roundNumber;
                cartCapacity = cartCapacity + roundNumber;
                speed += speed/5;
                break;
            case MEDIUM:
                this.cartCount = 10 * roundNumber;
                cartCapacity = cartCapacity + roundNumber * 2;
                break;
            case HARD:
                this.cartCount = 15 * roundNumber;
                cartCapacity = cartCapacity + roundNumber * 3;
                speed -= speed/5;
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
    public List<Cart> getResultCartList() {
        return resultCartList;
    }
    public void setResultCartList(List<Cart> resultCartList) {
        this.resultCartList = resultCartList;
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
    public Float getMoneyPerFillLevel() {
        return moneyPerFillLevel;
    }
    public List<Tower> getTowers() {
        return towerList;
    }
}
