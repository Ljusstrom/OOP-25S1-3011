public class Engine extends Part {
    private String engineType;

    public Engine(String engineType, String identifier, String manufacturer, String description, double cost) {
        super(identifier, manufacturer, description, cost);
        if (engineType.contains("...")) {
            System.out.println("Error");
        }
        else {
            this.engineType = engineType;
        }
    }

    public Engine(String engineType) {
        this(engineType, "", "", "", 0.0);
    }

    public String getEngineType() { return engineType; }
}