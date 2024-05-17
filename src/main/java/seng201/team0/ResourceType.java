public class ResourceType {
    private String name;
    private int index;
    private int valuePerUnit;

    // Constructor to initialize attributes
    public ResourceType(String name, int index, int valuePerUnit) {
        this.name = name;
        this.index = index;
        this.valuePerUnit = valuePerUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValuePerUnit() {
        return valuePerUnit;
    }

    public void setValuePerUnit(int valuePerUnit) {
        this.valuePerUnit = valuePerUnit;
    }
}
