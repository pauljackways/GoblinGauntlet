package seng201.team131;

/** 
 * An enum to to represnt all the game changers, is used in 3 switch cases, one for difficulty, one for the trade off and one for the powerups.
 */
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