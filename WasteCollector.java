package waste.management;

public abstract class WasteCollector {
    protected WasteCollector nextCollector;
    protected WasteContainer.WasteType collectorType;

    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    public abstract void collectWaste(WasteContainer container);

    protected void passToNext(WasteContainer container) {
        if (nextCollector != null) {
            nextCollector.collectWaste(container);
        } else {
            System.out.println("No suitable collector found for container: " + container.getId());
        }
    }
}