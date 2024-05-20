package seng201.team131;

public class Resource {
    private EnumResources type;
    private double value; // amount dispensed per reload
    private int reload; // reload time in seconds
    private int carts; // number of carts it can fill per reload

    public Resource(double value, int reload, int carts) {
        //this.type = type;
        this.value = value;
        this.reload = reload;
        this.carts = carts;
    }

    public EnumResources getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getReload() {
        return reload;
    }

    public void setReload(int reload) {
        this.reload = reload;
    }

    public int getCarts() {
        return carts;
    }

    public void setCarts(int carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "type=" + type +
                ", value=" + value +
                ", reload=" + reload +
                ", carts=" + carts +
                '}';
    }
}