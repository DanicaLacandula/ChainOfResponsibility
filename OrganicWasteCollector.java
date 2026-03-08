package waste.management;

public class OrganicWasteCollector extends WasteCollector {

    public OrganicWasteCollector() {
        this.collectorType = WasteContainer.WasteType.ORGANIC;
    }

    @Override
    public void collectWaste(WasteContainer container) {
        if (container.getType() == collectorType && container.isFull()) {
            System.out.println("Organic Waste Collector processing container: " + container.getId());
            System.out.println("Composting organic waste...");
            container.emptyContainer();
            System.out.println("Container emptied and ready for reuse.");
        } else {
            passToNext(container);
        }
    }
}