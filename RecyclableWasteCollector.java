package waste.management;

public class RecyclableWasteCollector extends WasteCollector {

    public RecyclableWasteCollector() {
        this.collectorType = WasteContainer.WasteType.RECYCLABLE;
    }

    @Override
    public void collectWaste(WasteContainer container) {
        if (container.getType() == collectorType && container.isFull()) {
            System.out.println("Recyclable Waste Collector processing container: " + container.getId());
            System.out.println("Sorting and processing recyclable materials...");
            container.emptyContainer();
            System.out.println("Container emptied and ready for reuse.");
        } else {
            passToNext(container);
        }
    }
}