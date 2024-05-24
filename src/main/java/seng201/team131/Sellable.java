package seng201.team131;
/**
 * Class for all items that are able to be sold in the marketplace
 */
public interface Sellable extends Selectable {
    String getName();
    int getLevel();
    String getDescription();
    Float getPrice();
}