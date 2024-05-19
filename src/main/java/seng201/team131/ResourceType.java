package seng201.team131;

public class ResourceType {
    private String name;
    private int valuePerUnit;
    // Constructor to initialize attributes
    public ResourceType(String name, int valuePerUnit) {
        this.name = name;
        this.valuePerUnit = valuePerUnit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getValuePerUnit() {
        return valuePerUnit;
    }

    public void setValuePerUnit(int valuePerUnit) {
        this.valuePerUnit = valuePerUnit;
    }
}
