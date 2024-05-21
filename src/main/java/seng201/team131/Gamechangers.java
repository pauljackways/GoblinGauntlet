package seng201.team131;

public class Gamechangers implements Selectable {
    private String name;
    private String image;
    private String description;
    public Gamechangers() {

    }
    public Gamechangers(EnumGamechangers type) {
        switch(type) {
            case EASY -> {
                this.description = "Order orcs to build you another\nlevel on one of your towers.\n\nFill more carts at greater volumes";
                this.image = "images/upgrade.jpeg";

                break;
            }
            

        }
        this.name = type.getGamechangerName();
    }
    public String getName() {
        return this.name;
    }
    public String getImage() {
        return "";
    }
    public String getDescription() {
        return "";
    }
}
