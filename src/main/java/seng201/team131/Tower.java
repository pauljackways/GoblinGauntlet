package seng201.team131;

import java.util.EnumMap;
import java.util.Map;
import static seng201.team131.EnumResources.*;

public class Tower implements Buyable, Sellable, Selectable {
    private String name;
    private Float cost;
    private float health; // Factor
    private int level;
    private String image;
    private float levelUpCost;
    private Map<EnumResources, Resource> resources = new EnumMap<>(EnumResources.class);

    public Tower(String name, float cost, int level, float levelUpCost, String image) {
        this.name = name;
        this.cost = cost;
        this.image = image;
        this.level = level;
        this.levelUpCost = levelUpCost;
        this.health = 1.0f; // Initialize health to 0
    }

    /// starting towers ///
    public Tower(EnumResources resource, String name, String image) {
        this.name = name;
        this.cost = 100f;
        this.level = 1;
        this.levelUpCost = 50;
        this.image = image;
        this.health = 1.0f; // Initialize damage to 0
        this.resources.put(GOO, new Resource(1f, 1, 1));
        this.resources.put(LAVA, new Resource(1f, 1, 1));
        this.resources.put(ETHER, new Resource(1f, 1, 1));


    }
    public void addResource(EnumResources resourceType, Resource resource) {
        resources.put(resourceType, resource);
    }

    public Resource getResource(EnumResources resourceType) {
        return resources.get(resourceType);
    }

    public void setResourceReload(EnumResources resourceType, int reloadTime) {
        Resource resource = resources.get(resourceType);
        if (resource != null) {
            resource.setReload(reloadTime);
        }
    }
    public void updateResource(EnumResources resourceType, Resource newResource) {
        resources.put(resourceType, newResource);
    }
    public String getDescription() {
        String description = getName() + "\nLevel: " + getLevel() + "\nDispenses:\n\n";
        for (int i = 0; i<3; i++) {
            description += EnumResources.values()[i].getResourceName() + ": \n" + this.getResource(EnumResources.values()[i]).getValue() + "\n" + this.getResource(EnumResources.values()[i]).getReload() + " second reload";
            if (i!=2) {
                description+= ",\n\n";
            }
        }
        return description;

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
    public double getPrice() {
        return this.cost / 2;
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