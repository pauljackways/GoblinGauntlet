package seng201.team131;


/**
 * An enum to switch between differant endings dependant on the amount of debt the player has.
 */
public enum EnumEndings {
    WIN("noob"),
    COLLECTOR("cool :)"),
    PRISON("level 100 boss"),
    SHAME(""),
    HOUSE(""),
    TRAIN(""),
    SACRIFICE(""),
    CRUCIFY(""),
    WIZARD("");

    private final String endingName;
    EnumEndings(String itemName) {
        this.endingName = itemName;
    }
    public String getEndingName() {
        return endingName;
    }
}