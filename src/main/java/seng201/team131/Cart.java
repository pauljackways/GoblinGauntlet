package seng201.team131;
import java.util.Random;
import static seng201.team131.EnumResources.*;


public class Cart implements Runnable {
    private Integer capacity;
    private EnumResources resourceType;
    private Integer favourResource;
    private Integer distanceTravelled = 0;
    private Float fillLevel;
    private Random random = new Random();
    private Float chanceEther;
    private Float chanceLava;


    public Cart (Integer favourResource, Float capacity) {
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

    public Float getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Float fillLevel) {
        this.fillLevel = fillLevel;
    }
    
    public String getDescription() {
        return "Capacity: " + capacity + "\n" +
               "Resource Type: " + resourceType + "\n" +
               "Fill Level: " + fillLevel;
    }

    @Override
    public void run() {
        distanceTravelled += 10;
    }
}
