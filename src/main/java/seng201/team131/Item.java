package seng201.team131;

public class Item implements Buyable, Selectable {
    private String name;
    private int count;
    private String image;
    private Float cost;
    private String description;

    private int level;
    public Item(String name, String description, float cost) {
        this.name = name;
        this.count = 0;
        this.description = description;
        this.cost = cost;
        this.level = 1;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public void levelUp() {
        level++;
    }


    public int getCount() {
        return count;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public Float getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return "Name: " + getName() + "\nDescription: " + description + "\nCost:" + getCost().toString();
    }
}
