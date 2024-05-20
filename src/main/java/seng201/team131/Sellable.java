package seng201.team131;

public interface Sellable extends Selectable {
    String getName();
    int getLevel();
    String getDescription();
    Float getPrice();
}