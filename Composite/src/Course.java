import java.util.ArrayList;
import java.util.List;

class Course implements CourseComponent {
    private String name;
    private List<CourseComponent> components = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    @Override
    public int computeDuration() {
        int total = 0;
        for (CourseComponent c : components) {
            total += c.computeDuration();
        }
        return total;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Course: " + name);
        for (CourseComponent c : components) {
            c.showDetails(indent + "   ");
        }
    }
}
