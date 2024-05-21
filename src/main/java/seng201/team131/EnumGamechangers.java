package seng201.team131;

public enum EnumGamechangers {
    EASY("noob"),
    MEDIUM("cool :)"),
    HARD("level 100 boss"),
    FAST(""),
    SABOTAGE(""),
    THEFT(""),
    SLOW(""),
    MONEY(""),
    DISTRIBUTION("");
    

    private final String gamechangerName;
        EnumGamechangers(String itemName) {
            this.gamechangerName = itemName;
    }
    public String getGamechangerName() {
        return gamechangerName;
    }
}