package seng201.team131;

public class Item {
    private String name;
    private int count;
    private ResourceType resourceType;
    private int fillLevel;

    public Item(String name, int count, ResourceType resourceType, int fillLevel) {
        this.name = name;
        this.count = count;
        this.resourceType = resourceType;
        this.fillLevel = fillLevel;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public void setFillLevel(int fillLevel) {
        this.fillLevel = fillLevel;
    }
}
