package seng201.team131;

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