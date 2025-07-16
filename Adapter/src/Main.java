public class Main {
    public static void main(String[] args) {
        TemperatureSensorLegacy tempLegacy = new TemperatureSensorLegacy();
        HumiditySensorLegacy humidityLegacy = new HumiditySensorLegacy();

        Sensor tempSensor = new TemperatureSensorAdapter(tempLegacy);
        Sensor humiditySensor = new HumiditySensorAdapter(humidityLegacy);

        System.out.println(tempSensor.getData());
        System.out.println(humiditySensor.getData());
    }
}