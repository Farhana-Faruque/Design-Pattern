class RedState implements State {
    @Override
    public void change(TrafficLight light) {
        System.out.println("Red Light ON for 10 seconds...");
        try {
            Thread.sleep(10000); // 10 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        light.setState(new YellowState());
    }
}