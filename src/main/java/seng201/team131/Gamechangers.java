package seng201.team131;

public class Gamechangers implements Selectable {
    private String name;
    private String image;
    private String description;
    private String resourceMoreCommon;

    public Gamechangers() {
    }
    public Gamechangers(EnumGamechangers type,  Integer resourceMoreCommon) {
        switch(resourceMoreCommon){
            case 0 -> this.resourceMoreCommon = "Ether";
            case 1 -> this.resourceMoreCommon = "Lava";
            case 2 -> this.resourceMoreCommon = "Goo";
            default -> this.resourceMoreCommon = "Unknown";
        }


        switch(type) {
            case EASY -> {
                this.description = "You could probaby do Medium";
                this.image = "images/baby.jpeg";
                break;
            }
            case MEDIUM -> {
                this.description = "You could probaby go to hard, \nhow hard could it be?";
                this.image = "images/medium.jpeg";

                break;
            }
            case HARD -> {
                this.description = "Are You sure?";
                this.image = "images/big.jpeg";

                break;
            }
            case FAST -> {
                this.description = "Speeds up the carts, \nbut you make more money. \nGo on take the Chance";
                this.image = "images/speed.jpeg";
                break;
            }
            case SABOTAGE -> {
                this.description = "Makes carts of a random \nresource fill up slower, \nbut you can make more money.";
                this.image = "images/sabotage.jpeg";

                break;
            }
            case THEFT -> {
                this.description = "Carts of a random resource fill \nup slower";
                this.image = "/images/OIG4..jpeg";

                break;
            }
            case SLOW -> {
                this.description = "Pretty self explanatory really...";
                this.image = "images/slow.jpeg";
                break;
            }
            case MONEY -> {
                this.description = "20% money boost for \none round";
                this.image = "images/rich.jpeg";

                break;
            }
            case DISTRIBUTION -> {
                this.description = "Makes " + this.resourceMoreCommon + " carts more likey";
                this.image = "images/distribution.jpeg";

                break;
            }
            default -> {
                break;
            }
        
            

            

        }
        this.name = type.getGamechangerName();
    }
    public String getName() {
        return this.name;
    }
    public String getImage() {
        return this.image;
    }
    public String getDescription() {
        return this.description;
    }
}
