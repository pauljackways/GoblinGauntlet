package seng201.team131;

public class Gamechangers implements Selectable {
    private String name;
    private String image;
    private String description;
    private String resourceMoreCommon;

    public Gamechangers() {}

    /**
     * sets the images and description on the sidebar, based on the selected object in the gamechangers screen.
     * @param type
     * @param resourceMoreCommon A random number between 0 and 2 used to set a certin resource car to be a little more likely.
     */
    public Gamechangers(EnumGamechangers type,  Integer resourceMoreCommon) {
        switch(resourceMoreCommon){
            case 0 -> this.resourceMoreCommon = "Ether";
            case 1 -> this.resourceMoreCommon = "Lava";
            case 2 -> this.resourceMoreCommon = "Goo";
            default -> this.resourceMoreCommon = "Unknown";
        }


        switch(type) {
            case EASY -> {
                this.description = "OK, Baby...";
                this.image = "images/baby.jpeg";
                break;
            }
            case MEDIUM -> {
                this.description = "Respectable.";
                this.image = "images/medium.jpeg";

                break;
            }
            case HARD -> {
                this.description = "Good luck :)";
                this.image = "images/big.jpeg";

                break;
            }
            case FAST -> {
                this.description = "The wizards pay you $500.00 to test\ntheir new rocket train spell";
                this.image = "images/speed.jpeg";
                break;
            }
            case SABOTAGE -> {
                this.description = "A giant troll has one of\nyour towers out of order,\nyou claim $500.00 of insurance\nand your tower is repaired\nwithin a day.";
                this.image = "images/sabotage.jpeg";

                break;
            }
            case THEFT -> {
                this.description = "A goblin is gobblin'\na pipeline of resources!\nThat resource pumps less today.\nThe resource is worth more\ntoday due to demand.";
                this.image = "/images/OIG4..jpeg";
                break;
            }
            case SLOW -> {
                this.description = "A gremlin guts spill is \nbogging down your carts";
                this.image = "images/slow.jpeg";
                break;
            }
            case MONEY -> {
                this.description = "A totally not suspicious Elf\nwill pay more for resources today.\nI wonder what he needs them for...";
                this.image = "images/rich.jpeg";

                break;
            }
            case DISTRIBUTION -> {
                this.description = "Your client needs more " + this.resourceMoreCommon + "\n and less of everything else today";
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
