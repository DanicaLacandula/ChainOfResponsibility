package waste.management;

public class HazardousWasteCollector extends WasteCollector {

    public HazardousWasteCollector() {
        this.collectorType = WasteContainer.WasteType.HAZARDOUS;
    }

    @Override
    public void collectWaste(WasteContainer container) {
        if (container.getType() == collectorType && container.isFull()) {
            System.out.println("Hazardous Waste Collector processing container: " + container.getId());
            System.out.println("Initiating hazardous waste disposal protocol...");
            System.out.println("WARNING: Handling hazardous materials with special precautions!");
            container.emptyContainer();
            System.out.println("Container emptied and decontaminated.");
        } else {
            passToNext(container);
        }
    }
}