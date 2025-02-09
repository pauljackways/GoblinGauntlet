package seng201.team131;

/**
 * enum consisting of the 3 resources, with some getter and setters.
 */
public enum EnumResources {
    ETHER("Ether Crystals"),
    LAVA("Lava"),
    GOO("Goo");
    private final String resourceName;
    private Float flowFactor;

    EnumResources(String resourceName) {
        this.resourceName = resourceName;
        this.flowFactor = 1.0f;
    }

    public String getResourceName() {
        return resourceName;
    }

    public double getFlowFactor() {
        return flowFactor;
    }

    public void setFlowFactor(Float flowFactor) {
        this.flowFactor = flowFactor;
    }
}