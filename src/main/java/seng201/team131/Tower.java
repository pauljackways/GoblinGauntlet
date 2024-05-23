package seng201.team131;

import java.util.List;
import java.util.Random;
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
  
    /// starting towers ///
    public Tower(List<EnumResources> resources, String name, String image, Integer level) {
        this.name = name;
        this.cost = 2000f * level;
        this.level = level;
        this.value = 3.0f;
        this.carts = 5;
        this.levelUpCost = 500;
        this.image = image;
        this.reload = 1000;
        this.health = 1.0f;
        this.resources = resources;
    }
    public Tower(List<EnumResources> resources, String name, String image, Integer level, Integer carts, Integer reload) {
        this.name = name;
        this.cost = 2000f * level;
        this.level = level;
        this.value = 3.0f;
        this.carts = carts;
        this.levelUpCost = this.cost/2;
        this.image = image;
        this.reload = 500 * reload;
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
        for (int i = 0; i < this.getResources().size(); i++) {
            String resourceName = EnumResources.values()[i].getResourceName();
            double tonnes = this.value * this.getResources().get(i).getFlowFactor();
            double reloadTime = this.getReload() / 1000.0;
            int cartsPerShot = this.getCarts();

            description += String.format("%s: \n%.2f Tonnes\n%.2f millisecond reload\n%d carts per shot",
                    resourceName, tonnes, reloadTime, cartsPerShot);

            if (i != this.getResources().size() - 1) {
                description += ",\n\n";
            } else {
                description += "\n\n";
            }
        }
        description += "Cost: \n$" + getCost();
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
    /**
     * A switch case to represnting the items the player can apply to their towers.
     * @param item A vlaue from the item enum, REPAI or UPGRADE 
     */
    public void useItem(Item item) {
        switch(item.getType()) {
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

    public void reduceRange() {
        carts = carts - 1;
    }

    public void increaceRange() {
        carts = carts + 1;
    }

    public void levelUp() {
        if (this.level < 10) {
            this.level++;
            switch (this.level) {
                case 3: {
                }
                case 5: {
                }
                char[] charArray = this.getImage().toCharArray();
                charArray[charArray.length - 6]++;
                this.setImage(String.valueOf(charArray));
            }
            this.cost += 250;
            this.reload = this.reload - (this.reload / 5);
            this.value = value * 1.2f;
        }
    }

    public void repairTwr(){
        if(this.health < 1){
            this.health =  this.health + 0.2f;
            this.value = this.value + 2f;
            this.reload = this.reload - 200;
            increaceRange();

        }
    }

    public void dmgTower(){

        this.health =  this.health - 0.2f;
        this.value = this.value - 2f;
        this.reload = this.reload + 200;
        if(getCarts() != 1){
            reduceRange();
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