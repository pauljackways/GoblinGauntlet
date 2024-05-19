package seng201.team131;

public enum EnumResources {
    ETHER("Ether Crystals"),
    LAVA("Lava"),
    GOO("Goo");

    private final String resourceName;

    EnumResources(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}