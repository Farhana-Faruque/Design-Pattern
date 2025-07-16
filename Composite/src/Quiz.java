class Quiz implements CourseComponent {
    private String name;
    private int duration; // in minutes

    public Quiz(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public int computeDuration() {
        return duration;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Quiz: " + name + " (" + duration + " mins)");
    }
}
