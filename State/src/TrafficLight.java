class TrafficLight {
    private State currentState;

    public TrafficLight() {
        currentState = new GreenState(); // start with green
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void change() {
        currentState.change(this);
    }
}