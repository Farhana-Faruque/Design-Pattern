public class TrafficLightSystem {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();

        while (true) {
            light.change();
        }
    }
}