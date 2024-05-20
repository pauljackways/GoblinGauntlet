package seng201.team131;

public enum EnumItems {
    REPAIR("Gremlins, daily hire"),
    UPGRADE("Building supplies (FREE labour)");
    private final String itemName;
    EnumItems(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }
}
