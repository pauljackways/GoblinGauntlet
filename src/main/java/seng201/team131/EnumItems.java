package seng201.team131;

/**
 * Enum with the two items used in the game changers screen, repair tower and upgradte tower.
 */
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


