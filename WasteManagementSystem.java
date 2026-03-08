package waste.management;

import java.util.ArrayList;
import java.util.List;

public class WasteManagementSystem {
    private List<WasteContainer> containers;
    private WasteCollector collectionChain;

    public WasteManagementSystem() {
        this.containers = new ArrayList<>();
        initializeCollectionChain();
    }

    private void initializeCollectionChain() {
        WasteCollector organicCollector = new OrganicWasteCollector();
        WasteCollector recyclableCollector = new RecyclableWasteCollector();
        WasteCollector hazardousCollector = new HazardousWasteCollector();

        organicCollector.setNextCollector(recyclableCollector);
        recyclableCollector.setNextCollector(hazardousCollector);

        this.collectionChain = organicCollector;
    }

    public void addContainer(WasteContainer container) {
        containers.add(container);
        System.out.println("✓ Container added: " + container.getId() + 
                         " [" + container.getType() + "]");
    }

    public void addWasteToContainer(String containerId, double amount) {
        for (WasteContainer container : containers) {
            if (container.getId().equals(containerId)) {
                double oldFillLevel = container.getCurrentFillLevel();
                container.addWaste(amount);
                
                System.out.printf("Added %.1f units to %s (%.1f/%.1f)%n", 
                    amount, containerId, container.getCurrentFillLevel(), container.getCapacity());
                
                if (container.isFull()) {
                    System.out.println("⚠ Container " + containerId + " is FULL. Triggering collection...");
                    triggerCollection(container);
                }
                return;
            }
        }
        System.out.println("✗ Container not found: " + containerId);
    }

    public void triggerCollection(WasteContainer container) {
        System.out.println("\n=== Starting Waste Collection Process ===");
        collectionChain.collectWaste(container);
        System.out.println("=== Collection Process Complete ===\n");
    }

    public void displayAllContainers() {
        System.out.println("\n=== Current Container Status ===");
        if (containers.isEmpty()) {
            System.out.println("No containers in the system.");
        } else {
            for (WasteContainer container : containers) {
                System.out.printf("• %s: %s - %.1f/%.1f units (%.0f%%)%n",
                    container.getId(),
                    container.getType(),
                    container.getCurrentFillLevel(),
                    container.getCapacity(),
                    container.getFillPercentage());
            }
        }
        System.out.println("================================\n");
    }
}