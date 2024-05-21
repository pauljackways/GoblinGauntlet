package seng201.team131;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static seng201.team131.EnumItems.*;
import static seng201.team131.EnumResources.*;

public class Tower implements Buyable, Sellable, Selectable, Runnable{
    private String name;
    private Float cost;
    private float health; // Factor
    private int level;
    private String image;
    private double value; // amount dispensed per resource per reload
    private Float reload; // reload time in seconds to reload
    private int carts; // number of carts it can fill per resource per reload
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
    public Tower(List<EnumResources> resource, String name, String image, Integer level) {
        this.name = name;
        this.cost = 100f * level;
        this.level = level;
        this.levelUpCost = 500;
        this.image = image;
        this.health = 1.0f; // Initialize damage to 0
        this.resources.addAll(resources);
    }
    public List<EnumResources> getResources() {
        return resources;
    }

    public void setReload(Float reload) {
        this.reload = reload;
    }
    public String getDescription() {
        String description = "\nLevel: " + getLevel() + "\n\n";
        for (int i = 0; i<this.getResources().size(); i++) {
            description += EnumResources.values()[i].getResourceName() + ": \n" + this.getResource(EnumResources.values()[i]).getValue() +
                    " Tonnes\n" + this.getResource(EnumResources.values()[i]).getReload() + " second reload";
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
    public void upgrade() {
        this.level++;
        switch(this.level) {
            case 3: {
            }
            case 5: {
            }
            ///////////////// Test this //////////////////////////
            String fileName = getImage().substring(getImage().lastIndexOf("/") + 1);
            String extension = fileName.substring(fileName.lastIndexOf("."));
            int numberIndex = fileName.length() - 6;
            int number = Character.getNumericValue(fileName.charAt(numberIndex));
            number++;
            String newFileName = fileName.substring(0, numberIndex) + number + extension;
            String newImagePath = getImage().substring(0, getImage().lastIndexOf("/") + 1) + newFileName;
            setImage(newImagePath);
        }
    }
    public void useItem(Item item) {
        switch(item.getType(item)) {
            case REPAIR -> {
                this.repair();
                break;
            }
            case UPGRADE -> {
                this.upgrade();
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