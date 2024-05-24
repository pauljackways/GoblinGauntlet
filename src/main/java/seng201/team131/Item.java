package seng201.team131;

public class Item implements Buyable, Selectable {
    private final EnumItems type;
    private String name;
    private int count;
    private String image;
    private Float cost;
    private String description;

    private int level;
    public Item(EnumItems type, String name, String description,  float cost) {
        this.type = type;
        this.name = name;
        this.count = 0;
        this.description = description;
        this.cost = cost;
        this.level = 1;
    }
    /**
     * A switch case for putting the selected item up in the sidebar with a description and image.
     * @param type
     */
    public Item(EnumItems type) {
        switch(type) {
            case REPAIR -> {
                this.cost = 500f;
                this.description = "Hire some gremlins to\n repair one of your towers.\n\nRepairs 1x easy damage\n0.5x medium damage.";
                this.image = "images/repair.jpeg";
                break;
            }
            case UPGRADE ->  {
                this.cost = 500f;
                this.description = "Order orcs to build you another\nlevel on one of your towers.\n\nFill more carts at greater volumes";
                this.image = "images/upgrade.jpeg";
                break;
            }
        }
        this.type = type;
        this.name = type.getItemName();
        this.level = 1;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public void levelUp() {
        level++;
    }
    public EnumItems getType() {
        return this.type;
    }
    public int getCount() {
        return count;
    }
    

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
        return "\n" + description + "\n\nCost: $" + getCost().toString();
    }
}
