package seng201.team131;

public class Tower implements Buyable, Sellable {
    private String name;
    private String imagePath;
    private float flowRate;
    private float resourceAmount;
    private float cost;
    private float health; // Factor
    private int level;
    private ResourceType resource;
    private float reloadSpeed;
    private float levelUpCost;

    public Tower(ResourceType resource, String name, float flowRate, float resourceAmount, float cost, int level, float reloadSpeed, float levelUpCost) {
        this.name = name;
        this.resource = resource;
        this.flowRate = flowRate;
        this.resourceAmount = resourceAmount;
        this.cost = cost;
        this.level = level;
        this.reloadSpeed = reloadSpeed;
        this.levelUpCost = levelUpCost;
        this.health = 1.0f; // Initialize health to 0
    }

    /// starting towers ///
    public Tower(ResourceType resource, String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.flowRate = 1;
        this.resourceAmount = 1;
        this.cost = 100;
        this.level = 1;
        this.reloadSpeed = 10;
        this.levelUpCost = 50;
        this.health = 1.0f; // Initialize damage to 0
    }
    public double getCost() {
        return cost;
    }
    public ResourceType getResource() {
        return this.resource;
    }
    public double getPrice() {
        return this.cost / 2;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImagePath(){
        return imagePath;
    }
    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    public double getFlowRate() {
        return flowRate;
    }
    public void setFlowRate(float flowRate) {
        this.flowRate = flowRate;
    }
public double getResourceAmount() {
        return resourceAmount;
    }
    public void setResourceAmount(float resourceAmount) {
        this.resourceAmount = resourceAmount;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getHealth() {
        return health;
    }

    public void setDamage(float health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getReloadSpeed() {
        return reloadSpeed;
    }

    public void setReloadSpeed(float reloadSpeed) {
        this.reloadSpeed = reloadSpeed;
    }

    public double getLevelUpCost() {
        return levelUpCost;
    }

    public void setLevelUpCost(float levelUpCost) {
        this.levelUpCost = levelUpCost;
    }

    public void dispense() {
    }

    public void levelUp() {

    }
}