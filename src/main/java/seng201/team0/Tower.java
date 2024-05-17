public class Tower {
    private String name;
    private int flowRate; ////chnage these later not sure how to do it.
    private int resourceAmount;
    private int cost;
    //maybe add another atribute to keep track fo damage to the tower!!!!!!!!!!!!!!!!!!!!!!
    private int level;
    private double reloadSpeed;
    private double levelUpCost;

    public Tower(String name, double flowRate, double resourceAmount, int cost, int level, double reloadSpeed, double levelUpCost){
        this.name = name;
        this.flowRate = flowRate;
        this.resourceAmount = resourceAmount;
        this.cost = cost;
        this. level = level
        this.reloadSpeed = reloadSpeed;
        this.levelUpCost = levelUpCost;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

    public double getResourceAmount() {
        return resourceAmount;
    }

    public void setResourceAmount(double resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getReloadSpeed() {
        return reloadSpeed;
    }

    public void setReloadSpeed(double reloadSpeed) {
        this.reloadSpeed = reloadSpeed;
    }

    public double getLevelUpCost() {
        return levelUpCost;
    }

    public void setLevelUpCost(double levelUpCost) {
        this.levelUpCost = levelUpCost;
    }
}











    public void repair(){

    }

    public void display(){

    }

    public void dispense(){

    }

    public void levelUp(){
        level++;
    }






























        public Machine(String name, double flowRate, double resourceAmount, double cost, int level, double reloadSpeed, double levelUpCost) {
            this.name = name;
            this.flowRate = flowRate;
            this.resourceAmount = resourceAmount;
            this.cost = cost;
            this.level = level;
            this.reloadSpeed = reloadSpeed;
            this.levelUpCost = levelUpCost;
        }
    
        public void repair() {
            System.out.println("Repairing " + name + "...");
            // Add logic for repairing the machine
        }
    
        public void display() {
            System.out.println("Name: " + name);
            System.out.println("Flow Rate: " + flowRate);
            System.out.println("Resource Amount: " + resourceAmount);
            System.out.println("Cost: " + cost);
            System.out.println("Level: " + level);
            System.out.println("Reload Speed: " + reloadSpeed);
            System.out.println("Level Up Cost: " + levelUpCost);
        }
    
        public void dispense() {
            System.out.println("Dispensing resources from " + name + "...");
            // Add logic for dispensing resources
        }
    
        public void levelUp() {
            System.out.println("Leveling up " + name + "...");
            if (resourceAmount >= levelUpCost) {
                level++;
                resourceAmount -= levelUpCost;
                System.out.println(name + " leveled up to " + level + "!");
            } else {
                System.out.println("Not enough resources to level up " + name + ".");
            }
        }
    
        // Getters and Setters if needed
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            th
    