package seng201.team131;

public class Tower {
    private String name;
    private double flowRate; // Changed to double
    private double resourceAmount; // Changed to double
    private int cost;
    private int damage; // New attribute to track damage
    private int level;
    private double reloadSpeed;
    private double levelUpCost;

    public Tower(String name, double flowRate, double resourceAmount, int cost, int level, double reloadSpeed, double levelUpCost) {
        this.name = name;
        this.flowRate = flowRate;
        this.resourceAmount = resourceAmount;
        this.cost = cost;
        this.level = level;
        this.reloadSpeed = reloadSpeed;
        this.levelUpCost = levelUpCost;
        this.damage = 0; // Initialize damage to 0
    }
    public Tower(String name) {
        this.name = name;
        this.name = name;
        this.flowRate = 1.0; // Default value
        this.resourceAmount = 100.0; // Default value
        this.cost = 500; // Default value
        this.level = 1; // Default value
        this.reloadSpeed = 1.5; // Default value
        this.levelUpCost = 200.0; // Default value
        this.damage = 0; // Initialize damage to 0
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

    public double getResourceAmount() {
        return resourceAmount;
    }

    public void setResourceAmount(double resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public void setReloadSpeed(double reloadSpeed) {
        this.reloadSpeed = reloadSpeed;
    }

    public double getLevelUpCost() {
        return levelUpCost;
    }

    public void setLevelUpCost(double levelUpCost) {
        this.levelUpCost = levelUpCost;
    }

    public void repair() {
        this.damage = 0; // Reset damage to 0
        System.out.println(name + " has been repaired.");
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Flow Rate: " + flowRate);
        System.out.println("Resource Amount: " + resourceAmount);
        System.out.println("Cost: " + cost);
        System.out.println("Damage: " + damage);
        System.out.println("Level: " + level);
        System.out.println("Reload Speed: " + reloadSpeed);
        System.out.println("Level Up Cost: " + levelUpCost);
    }

    public void dispense() {
        System.out.println("Dispensing resources from " + name + "...");
        // Add logic for dispensing resources
    }

    public void levelUp() {
        if (resourceAmount >= levelUpCost) {
            level++;
            resourceAmount -= levelUpCost;
            System.out.println(name + " leveled up to " + level + "!");
        } else {
            System.out.println("Not enough resources to level up " + name + ".");
        }
    }
}