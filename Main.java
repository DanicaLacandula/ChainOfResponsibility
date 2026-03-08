package waste.management;

public class Main {
    public static void main(String[] args) {
        System.out.println("AUTOMATED WASTE MANAGEMENT SYSTEM");
        System.out.println("===================================\n");

        // Initialize the waste management system
        WasteManagementSystem system = new WasteManagementSystem();

        // Create different types of waste containers
        WasteContainer organicContainer = new WasteContainer("ORG001", 
                WasteContainer.WasteType.ORGANIC, 100.0);
        
        WasteContainer recyclableContainer = new WasteContainer("REC001", 
                WasteContainer.WasteType.RECYCLABLE, 150.0);
        
        WasteContainer hazardousContainer = new WasteContainer("HAZ001", 
                WasteContainer.WasteType.HAZARDOUS, 50.0);

        // Add containers to the system
        System.out.println("Adding containers to system:");
        System.out.println("----------------------------");
        system.addContainer(organicContainer);
        system.addContainer(recyclableContainer);
        system.addContainer(hazardousContainer);

        // Display initial status
        system.displayAllContainers();

        // Simulate waste addition and collection process
        System.out.println("Simulating Waste Collection Process");
        System.out.println("------------------------------------\n");

        // Organic waste
        System.out.println("Case 1: Organic Waste");
        system.addWasteToContainer("ORG001", 80.0);
        system.addWasteToContainer("ORG001", 30.0);

        // Recyclable waste
        System.out.println("\nCase 2: Recyclable Waste");
        system.addWasteToContainer("REC001", 150.0);

        // Hazardous waste
        System.out.println("\nCase 3: Hazardous Waste");
        system.addWasteToContainer("HAZ001", 30.0);
        system.addWasteToContainer("HAZ001", 25.0);

        // Display final status
        system.displayAllContainers();

        // Test edge cases
        System.out.println("Testing Edge Cases");
        System.out.println("------------------");
        
        // Test 1: Container not found
        System.out.println("Test 1: Non-existent container");
        system.addWasteToContainer("INVALID001", 10.0);
        
        // Test 2: Container not full
        System.out.println("\nTest 2: Manual collection of non-full container");
        WasteContainer testContainer = new WasteContainer("TEST001", 
                WasteContainer.WasteType.ORGANIC, 100.0);
        system.addContainer(testContainer);
        system.addWasteToContainer("TEST001", 50.0);
        System.out.println("Manual collection attempt:");
        system.triggerCollection(testContainer);
        
        // Test 3: Invalid waste amount
        System.out.println("\nTest 3: Invalid waste amount");
        try {
            system.addWasteToContainer("TEST001", -10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Error: " + e.getMessage());
        }

        System.out.println("\n===================================");
        System.out.println("SYSTEM DEMO COMPLETED");
        System.out.println("===================================");
    }
}