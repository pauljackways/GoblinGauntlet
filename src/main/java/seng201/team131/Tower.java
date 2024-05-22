package seng201.team131;

import java.util.List;
import java.util.stream.Collectors;

public class Tower implements Buyable, Sellable, Selectable, Runnable{
    private String name;
    private Float cost;
    private float health; // Factor
    private int level;
    private String image;
    private Float value; // amount dispensed per resource per reload
    private Integer reload; // reload time in Milliseconds to reload
    private Integer carts; // number of carts it can fill per resource per reload
    private float levelUpCost;
    private List<EnumResources> resources;

    public Tower(String name, float cost, int level, float levelUpCost, String image) {
        this.name = name;
        this.cost = cost;
        this.image = image;
        this.level = level;
        this.levelUpCost = levelUpCost;
        this.health = 1.0f; // Initialize health to 0
    }

    /// starting towers ///
    public Tower(List<EnumResources> resources, String name, String image, Integer level) {
        this.name = name;
        this.cost = 100f * level;
        this.level = level;
        this.value = 10.0f;
        this.carts = 5;
        this.levelUpCost = 500;
        this.image = image;
        this.reload = 1000;
        this.health = 1.0f; // Initialize health to 1.0
        this.resources = resources;
    }
    public List<EnumResources> getResources() {
        return resources;
    }

    public void setReload(Integer reload) {
        this.reload = reload;
    }
    public long getReload() {
        return this.reload;
    }
    public String getDescription() {
        String description = "\nLevel: " + getLevel() + "\n\n";
        for (int i = 0; i<this.getResources().size(); i++) {
            description += EnumResources.values()[i].getResourceName() + ": \n" + this.value*this.getResources().get(i).getFlowFactor() +
                    " Tonnes\n" + this.getReload()/1000 + " second reload\n" + this.getCarts() + " carts per shot";
            if (i != 2) {
                description += ",\n\n";
            } else {
                description += "\n\n";
            }
        }
        description+= "Cost: \n$" + getCost();
        return description;

    }
    public void run() {

    }
    public void repair() {
        if (this.health >= 0.8) {
            health = 1.0f;
        } else {
            this.health += 0.2;
        }
    }
    public void useItem(Item item) {
        switch(item.getType(item)) {
            case REPAIR -> {
                this.repair();
                break;
            }
            case UPGRADE -> {
                this.levelUp();
                break;
            }
        }
    }

    public Float getCost() {
        return cost;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String getImage() {
        return this.image;
    }
    public Float getPrice() {
        return this.getCost() / 2;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(Float cost) {
        this.cost = cost;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public Integer getCarts() {
        return carts;
    }

    public void levelUp(){
        if(this.level < 10){
            this.level++;
            switch(this.level) {
                case 3: {
                }
                case 5: {
                }
                char[] charArray = this.getImage().toCharArray();
                charArray[charArray.length-6]++;
                this.setImage(String.valueOf(charArray));
            }
            this.cost += 250;
            this.reload = this.reload - (this.reload/5);
            this.value = value * 1.2f;
        }




    }

    public double getLevelUpCost() {
        return levelUpCost;
    }
    public Float getValue() {
        return value;
    }

    public void setLevelUpCost(float levelUpCost) {
        this.levelUpCost = levelUpCost;
    }

}