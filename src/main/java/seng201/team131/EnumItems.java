package seng201.team131;

public enum EnumItems {
    REPAIR("Fixerer Thingy"),
    UPGRADE("Leveler Upperer");
    private final String itemName;
    EnumItems(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }


}
