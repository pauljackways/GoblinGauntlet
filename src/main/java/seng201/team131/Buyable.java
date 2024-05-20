package seng201.team131;

public interface Buyable extends Selectable {
    String getName();
    int getLevel();
    String getDescription();
    Float getCost();
}