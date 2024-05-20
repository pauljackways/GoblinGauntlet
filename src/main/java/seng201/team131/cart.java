package seng201.team131;

public class cart {
    private Integer capacity;
    private EnumResources resourceType;
    private Integer speed;
    private Integer fillLevel;

    // Constructor
    public cart() {
        // Initialize default values
        this.capacity = 0;
        this.resourceType = null;
        this.speed = 0;
        this.fillLevel = 0;
    }

    // Getters and setters
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public EnumResources getResourceType() {
        return resourceType;
    }

    public void setResourceType(EnumResources resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Integer fillLevel) {
        this.fillLevel = fillLevel;
    }
}
