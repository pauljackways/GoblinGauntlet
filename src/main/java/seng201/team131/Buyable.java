package seng201.team131;

/**
 * Class for all items that are able to be bought in the marketplace
 */
public interface Buyable extends Selectable {
    String getName();
    int getLevel();
    String getDescription();
    Float getCost();
}