package waste.management;

public class WasteContainer {
    private String id;
    private WasteType type;
    private double capacity;
    private double currentFillLevel;
    private boolean isFull;

    public enum WasteType {
        ORGANIC, RECYCLABLE, HAZARDOUS
    }

    public WasteContainer(String id, WasteType type, double capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.currentFillLevel = 0.0;
        this.isFull = false;
    }

    public String getId() {
        return id;
    }

    public WasteType getType() {
        return type;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentFillLevel() {
        return currentFillLevel;
    }

    public boolean isFull() {
        return isFull;
    }

    public double getFillPercentage() {
        return (currentFillLevel / capacity) * 100;
    }

    public void addWaste(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Waste amount cannot be negative");
        }
        
        this.currentFillLevel += amount;
        if (this.currentFillLevel >= this.capacity) {
            this.isFull = true;
            this.currentFillLevel = this.capacity;
        }
    }

    public void emptyContainer() {
        this.currentFillLevel = 0.0;
        this.isFull = false;
    }
}