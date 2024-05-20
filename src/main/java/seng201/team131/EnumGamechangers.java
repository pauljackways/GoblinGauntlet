package seng201.team131;

public enum EnumGamechangers {
    EASY("noob"),
    MEDIUM("cool :)"),
    HARD("level 100 boss"),
    FAST(""),
    SLOW(""),
    SABOTAGE(""),
    MONEY(""),
    DISTRIBUTION(""),
    THEFT("");

    private final String gamechangerName;
    EnumGamechangers(String itemName) {
        this.gamechangerName = itemName;
    }
    public String getGamechangerName() {
        return gamechangerName;
    }
}