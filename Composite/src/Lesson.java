import java.util.ArrayList;
import java.util.List;

class Lesson implements CourseComponent {
    private String name;
    private int duration; // in minutes
    private List<CourseComponent> components = new ArrayList<>();

    public Lesson(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    @Override
    public int computeDuration() {
        int total = duration;
        for (CourseComponent c : components) {
            total += c.computeDuration();
        }
        return total;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Lesson: " + name + " (" + duration + " mins)");
        for (CourseComponent c : components) {
            c.showDetails(indent + "   ");
        }
    }
}


