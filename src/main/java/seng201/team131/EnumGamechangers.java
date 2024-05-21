package seng201.team131;

public enum EnumGamechangers {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("level 100 boss"),
    FAST("Cart Speed Up"),
    SABOTAGE("Name Here"),
    THEFT("He is stealing your \nresources!!!"),
    SLOW("Slow Down Carts"),
    MONEY("More Money!!!"),
    DISTRIBUTION("Random Resource Nerf");
    

    private final String gamechangerName;
        EnumGamechangers(String itemName) {
            this.gamechangerName = itemName;
    }
    public String getGamechangerName() {
        return gamechangerName;
    }
}