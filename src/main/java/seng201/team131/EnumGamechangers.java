package seng201.team131;

public enum EnumGamechangers {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    FAST("Speed"),
    SABOTAGE("Sabotage"),
    THEFT("Theft"),
    SLOW("Slow"),
    MONEY("Non-suspicious Elf"),
    DISTRIBUTION("Distribution");
    

    private final String gamechangerName;
        EnumGamechangers(String itemName) {
            this.gamechangerName = itemName;
    }
    public String getGamechangerName() {
        return gamechangerName;
    }
}