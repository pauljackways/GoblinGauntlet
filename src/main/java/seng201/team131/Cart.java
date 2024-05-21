package seng201.team131;
import java.util.Random;
import static seng201.team131.EnumResources.*;


public class Cart implements Runnable {
    private Float capacity;
    private EnumResources resourceType;
    private Integer favourResource;
    private Integer distanceTravelled = 0;
    private Float fillLevel;
    private Random random = new Random();
    private Float chanceEther;
    private Float chanceLava;
    public Cart (Float capacity) {
        this.favourResource = -1;
        this.capacity = 10.0f;
        this.fillLevel = 0.0f;
    }
    public Cart (Integer favourResource, Float capacity) {
        this.capacity = capacity;
        this.favourResource = favourResource;
        this.fillLevel = 0.0f;
        switch (favourResource) {
            case 0: {
                chanceEther = 0.6f;
                chanceLava = 0.2f;
                break;
            }
            case 1: {
                chanceEther = 0.2f;
                chanceLava = 0.6f;
                break;
            }
            case 2: {
                chanceEther = 0.2f;
                chanceLava = 0.2f;
                break;
            }
            case 3: {
                chanceEther = 0.33333f;
                chanceLava = 0.33333f;
                break;
            }
            default: {
                chanceEther = 0.33333f;
                chanceLava = 0.33333f;
            }
        }
        float randomValue = random.nextFloat();
        if (randomValue < chanceEther) {
            this.resourceType = ETHER;
        } else if (randomValue < chanceEther + chanceLava) {
            this.resourceType = LAVA;
        } else {
            this.resourceType = GOO;
        }
    }

    public EnumResources getResourceType() {
        return resourceType;
    }

    public Integer getFavourResource(){
        return favourResource;
    }

    public Float getFillLevel() {
        return fillLevel;
    }
    public Float getCapacity() {
        return capacity;
    }

    public void fill(Float fill) {
        this.fillLevel += fill;
        if (this.fillLevel > this.capacity) {
            this.fillLevel = this.capacity;
        }
    }
    @Override
    public String toString() { //For the observableList
        if (favourResource != -1) {
            return "[#] " + fillLevel + "/" + capacity + " " + resourceType.getResourceName();
        } else {
            return "";
        }
    }

    @Override
    public void run() {
        distanceTravelled += 10;
    }
}
