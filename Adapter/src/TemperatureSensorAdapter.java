public class TemperatureSensorAdapter implements Sensor {
    private TemperatureSensorLegacy tempSensor;

    public TemperatureSensorAdapter(TemperatureSensorLegacy tempSensor) {
        this.tempSensor = tempSensor;
    }

    @Override
    public String getData() {
        return "Temperature Sensor: " + tempSensor.readTemp() + "°C";
    }
}